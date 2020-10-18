
package acme.features.administrator.itemCategory;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.configuration.ItemCategory;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractListService;

@Service
public class AdministratorItemCategoryListService implements AbstractListService<Administrator, ItemCategory> {

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
	public Collection<ItemCategory> findMany(final Request<ItemCategory> request) {
		assert request != null;

		Collection<ItemCategory> result = repository.findMany();

		return result;
	}

}
