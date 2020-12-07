
package acme.features.supplier.section;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.configuration.SpamUtils;
import acme.entities.items.Item;
import acme.entities.roles.Supplier;
import acme.entities.sections.Section;
import acme.features.authenticated.supplier.AuthenticatedSupplierRepository;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractCreateService;

@Service
public class SupplierSectionCreateService implements AbstractCreateService<Supplier, Section> {

	@Autowired
	SupplierSectionRepository		repository;

	@Autowired
	AuthenticatedSupplierRepository	supplierRepository;

	@Autowired
	private SpamUtils				spamUtils;


	@Override
	public boolean authorise(final Request<Section> request) {
		assert request != null;
		return true;
	}

	@Override
	public void bind(final Request<Section> request, final Section entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
	}

	@Override
	public void unbind(final Request<Section> request, final Section entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		model.setAttribute("item.title", entity.getItem().getTitle());
		model.setAttribute("item.id", entity.getItem().getId());
		request.unbind(entity, model, "title", "description", "photo");
	}

	@Override
	public Section instantiate(final Request<Section> request) {
		Section result = new Section();
		int itemId = request.getModel().getInteger("item.id");
		Item item = repository.findItemById(itemId);
		result.setItem(item);
		return result;
	}

	@Override
	public void validate(final Request<Section> request, final Section entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		errors.state(request, !spamUtils.checkSpam(entity.getTitle()), "title", "acme.validation.spam",
			spamUtils.getThreshold(), spamUtils.getSpamWords());
		errors.state(request, !spamUtils.checkSpam(entity.getDescription()), "description", "acme.validation.spam",
			spamUtils.getThreshold(), spamUtils.getSpamWords());
	}

	@Override
	public void create(final Request<Section> request, final Section entity) {
		assert request != null;
		assert entity != null;

		int itemId = request.getModel().getInteger("item.id");
		synchronized (this) {
			Collection<Section> result = repository.findManyByItemId(itemId);
			if (result.isEmpty())
				entity.setIndex(1);
			else
				entity.setIndex(result.size() + 1);

			repository.save(entity);
		}

	}
}
