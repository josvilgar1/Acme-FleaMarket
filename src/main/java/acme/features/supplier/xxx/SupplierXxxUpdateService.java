
package acme.features.supplier.xxx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.configuration.SpamUtils;
import acme.entities.roles.Supplier;
import acme.entities.xxx.Xxx;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractUpdateService;

@Service
public class SupplierXxxUpdateService implements AbstractUpdateService<Supplier, Xxx> {

	@Autowired
	SupplierXxxRepository	repository;

	@Autowired
	private SpamUtils		spamUtils;


	@Override
	public boolean authorise(Request<Xxx> request) {
		assert request != null;

		int supplierPrincipalId = request.getPrincipal().getActiveRoleId();
		Xxx xxx = repository.findOneById(request.getModel().getInteger("id"));

		if (xxx.getItem().getSupplier().getId() != supplierPrincipalId)
			return false;

		return true;
	}

	@Override
	public void bind(Request<Xxx> request, Xxx entity, Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
	}

	@Override
	public void unbind(Request<Xxx> request, Xxx entity, Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "text", "priceMin", "priceMax", "code", "item.title");
	}

	@Override
	public Xxx findOne(Request<Xxx> request) {
		assert request != null;

		Xxx item = new Xxx();
		int id = request.getModel().getInteger("id");
		item = repository.findOneById(id);

		return item;
	}

	@Override
	public void validate(Request<Xxx> request, Xxx entity, Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		// comprobamos palabras spam en el texto
		errors.state(request, !spamUtils.checkSpam(entity.getText()), "text", "acme.validation.spam",
			spamUtils.getThreshold(), spamUtils.getSpamWords());

		if (!errors.hasErrors("priceMin"))
			errors.state(request, entity.getPriceMin().getAmount() < entity.getPriceMax().getAmount(), "priceMin",
				"supplier.xxx.form.errors.pricemin", entity.getItem().getPrice());
		if (!errors.hasErrors("priceMax"))
			errors.state(request, entity.getPriceMax().getAmount() < entity.getItem().getPrice().getAmount(),
				"priceMax", "supplier.xxx.form.errors.pricemax", entity.getItem().getPrice());
	}

	@Override
	public void update(Request<Xxx> request, Xxx entity) {
		assert request != null;
		assert entity != null;

		repository.save(entity);
	}

}
