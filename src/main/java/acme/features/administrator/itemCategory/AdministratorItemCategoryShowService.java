
package acme.features.administrator.itemCategory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.configuration.ItemCategory;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractShowService;

@Service
public class AdministratorItemCategoryShowService implements AbstractShowService<Administrator, ItemCategory> {

	@Autowired
	AdministratorItemCategoryRepository repository;


	@Override
	public boolean authorise(final Request<ItemCategory> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<ItemCategory> request, final ItemCategory entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "items");

	}

	@Override
	public ItemCategory findOne(final Request<ItemCategory> request) {
		assert request != null;

		ItemCategory ItemCategory;
		int id = request.getModel().getInteger("id");

		ItemCategory = repository.findOneItemCategoryById(id);

		return ItemCategory;
	}

}
