
package acme.features.supplier.items;

import java.util.Hashtable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.items.Item;
import acme.entities.roles.Supplier;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractDeleteService;

@Service
public class SupplierItemDeleteService implements AbstractDeleteService<Supplier, Item> {

	@Autowired
	SupplierItemRepository repository;


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

		request.unbind(entity, model);
	}

	@Override
	public Item findOne(Request<Item> request) {
		assert request != null;

		Item item;
		int id = request.getModel().getInteger("id");
		item = repository.findOneById(id);

		return item;
	}

	@Override
	public void validate(Request<Item> request, Item entity, Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		boolean containsRequest = repository.findAllRequestByItemId(entity.getId()).isEmpty();
		errors.state(request, containsRequest, "haveErrors", "supplier.item.form.errors.have.request");

		if (errors.hasErrors("haveErrors")) {
			Hashtable<String, Object> properties = new Hashtable<>();
			properties.put("haveSections", !containsRequest);
			properties.put("haveXxx", !repository.findXxxByItemId(entity.getId()).isEmpty());
			toMapAttributes(request, entity, properties);
		}
	}

	@Override
	public void delete(Request<Item> request, Item entity) {
		assert request != null;
		assert entity != null;

		// eliminamos los mensajes del item
		repository.deleteMessagesByItem(entity.getId());
		// eliminamos el foro del item
		repository.deleteForumByItem(entity.getId());
		// eliminamos las secciones del item
		repository.deleteSectionsByItem(entity.getId());
		// eliminamos los registros de auditoria del item
		repository.deleteAuditrecordByItem(entity.getId());
		// eliminamos la entidad nueva
		repository.deleteXxxByItem(entity.getId());
		repository.delete(entity);
	}

}
