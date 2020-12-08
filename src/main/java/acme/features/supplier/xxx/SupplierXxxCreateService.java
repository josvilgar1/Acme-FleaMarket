
package acme.features.supplier.xxx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.configuration.SpamUtils;
import acme.entities.items.Item;
import acme.entities.roles.Supplier;
import acme.entities.xxx.Xxx;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractCreateService;

@Service
public class SupplierXxxCreateService implements AbstractCreateService<Supplier, Xxx> {

	@Autowired
	SupplierXxxRepository	repository;

	@Autowired
	private SpamUtils		spamUtils;


	@Override
	public boolean authorise(final Request<Xxx> request) {
		assert request != null;
		return true;
	}

	@Override
	public void bind(final Request<Xxx> request, final Xxx entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
	}

	@Override
	public void unbind(final Request<Xxx> request, final Xxx entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "item.title");
	}

	@Override
	public Xxx instantiate(final Request<Xxx> request) {
		Xxx result = new Xxx();
		int itemId = request.getModel().getInteger("item.id");
		Item item = repository.findItemById(itemId);
		result.setItem(item);
		return result;
	}

	@Override
	public void validate(final Request<Xxx> request, final Xxx entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		// comprobamos palabras spam en el texto
		errors.state(request, !spamUtils.checkSpam(entity.getText()), "text", "acme.validation.spam",
			spamUtils.getThreshold(), spamUtils.getSpamWords());
	}

	@Override
	public void create(final Request<Xxx> request, final Xxx entity) {
		assert request != null;
		assert entity != null;

		repository.save(entity);
	}
}
