
package acme.features.supplier.section;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.configuration.SpamUtils;
import acme.entities.roles.Supplier;
import acme.entities.sections.Section;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractUpdateService;

@Service
public class SupplierSectionUpdateService implements AbstractUpdateService<Supplier, Section> {

	@Autowired
	SupplierSectionRepository	repository;

	@Autowired
	private SpamUtils			spamUtils;


	@Override
	public boolean authorise(Request<Section> request) {
		assert request != null;

		int supplierPrincipalId = request.getPrincipal().getActiveRoleId();
		Section section = repository.findOneById(request.getModel().getInteger("id"));

		if (section.getItem().getSupplier().getId() != supplierPrincipalId)
			return false;

		return true;
	}

	@Override
	public void bind(Request<Section> request, Section entity, Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
	}

	@Override
	public void unbind(Request<Section> request, Section entity, Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		model.setAttribute("status", entity.getItem().getStatus());
		request.unbind(entity, model, "item.id", "item.title", "index", "title", "description", "photo");
	}

	@Override
	public Section findOne(Request<Section> request) {
		assert request != null;

		Section item = new Section();
		int id = request.getModel().getInteger("id");
		item = repository.findOneById(id);

		return item;
	}

	@Override
	public void validate(Request<Section> request, Section entity, Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		// comprobamos palabras spam en el título y la descripción
		errors.state(request, !spamUtils.checkSpam(entity.getTitle()), "title", "acme.validation.spam",
			spamUtils.getThreshold(), spamUtils.getSpamWords());
		errors.state(request, !spamUtils.checkSpam(entity.getDescription()), "description", "acme.validation.spam",
			spamUtils.getThreshold(), spamUtils.getSpamWords());
	}

	@Override
	public void update(Request<Section> request, Section entity) {
		assert request != null;
		assert entity != null;

		repository.save(entity);
	}

}
