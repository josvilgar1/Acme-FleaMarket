
package acme.features.administrator.itemCategory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.configuration.ItemCategory;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractUpdateService;

@Service
public class AdministratorItemCategoryUpdateService implements AbstractUpdateService<Administrator, ItemCategory> {

	@Autowired
	AdministratorItemCategoryRepository repository;


	@Override
	public boolean authorise(final Request<ItemCategory> request) {
		assert request != null;

		return true;
	}

	@Override
	public void bind(final Request<ItemCategory> request, final ItemCategory entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
	}

	@Override
	public void unbind(final Request<ItemCategory> request, final ItemCategory entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "categories");
	}

	@Override
	public ItemCategory findOne(final Request<ItemCategory> request) {
		assert request != null;

		ItemCategory ItemCategory;
		int id = request.getModel().getInteger("id");

		ItemCategory = repository.findOneItemCategoryById(id);

		return ItemCategory;
	}

	@Override
	public void validate(final Request<ItemCategory> request, final ItemCategory entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
	}

	@Override
	public void update(final Request<ItemCategory> request, final ItemCategory entity) {
		assert request != null;
		assert entity != null;

		repository.save(entity);
	}

}
