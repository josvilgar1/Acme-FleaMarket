
package acme.features.supplier.items;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.configuration.SpamUtils;
import acme.entities.items.Item;
import acme.entities.roles.Supplier;
import acme.enumeration.Status;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractUpdateService;

@Service
public class SupplierItemUpdateService implements AbstractUpdateService<Supplier, Item> {

	@Autowired
	SupplierItemRepository	repository;

	@Autowired
	private SpamUtils		spamUtils;


	@Override
	public boolean authorise(Request<Item> request) {
		assert request != null;

		int supplierPrincipalId = request.getPrincipal().getActiveRoleId();
		Item item = repository.findOneById(request.getModel().getInteger("id"));

		if (item.getSupplier().getId() != supplierPrincipalId)
			return false;

		return true;
	}

	@Override
	public void bind(Request<Item> request, Item entity, Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
	}

	@Override
	public void unbind(Request<Item> request, Item entity, Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "itemCategory", "description", "price", "photo", "link", "status");
	}

	@Override
	public Item findOne(Request<Item> request) {
		assert request != null;

		Item item = new Item();
		int id = request.getModel().getInteger("id");
		item = repository.findOneById(id);

		return item;
	}

	@Override
	public void validate(Request<Item> request, Item entity, Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		// antes de publicar se debe comprobar que tenga almenos una sección
		if (!errors.hasErrors("status") && entity.getStatus().equals(Status.PUBLISHED))
			errors.state(request, !repository.findAllSectionByItemId(entity.getId()).isEmpty(), "haveErrors",
				"supplier.item.form.errors.section.empty");

		// comprobamos palabras spam en el título y la descripción
		errors.state(request, !spamUtils.checkSpam(entity.getTitle()), "title", "acme.validation.spam",
			spamUtils.getThreshold(), spamUtils.getSpamWords());
		errors.state(request, !spamUtils.checkSpam(entity.getDescription()), "description", "acme.validation.spam",
			spamUtils.getThreshold(), spamUtils.getSpamWords());

		if (errors.hasErrors()) {
			request.getModel().setAttribute("haveSections",
				!repository.findAllSectionByItemId(entity.getId()).isEmpty());
			request.getModel().setAttribute("haveXxx", !repository.findXxxByItemId(entity.getId()).isEmpty());
			request.getModel().setAttribute("status", Status.DRAFT);
		}
	}

	@Override
	public void update(Request<Item> request, Item entity) {
		assert request != null;
		assert entity != null;

		repository.save(entity);
	}

}
