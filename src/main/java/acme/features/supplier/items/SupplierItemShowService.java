
package acme.features.supplier.items;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.items.Item;
import acme.entities.roles.Supplier;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractShowService;

@Service
public class SupplierItemShowService implements AbstractShowService<Supplier, Item> {

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
	public void unbind(Request<Item> request, Item entity, Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "id", "ticker", "creationMoment", "title", "itemCategory", "description", "price",
			"photo", "link");
	}

	@Override
	public Item findOne(Request<Item> request) {
		assert request != null;

		Item result;

		int id = request.getModel().getInteger("id");
		result = repository.findOneById(id);

		return result;
	}

}
