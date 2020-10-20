
package acme.features.administrator.newCategory;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.configuration.NewCategory;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractListService;

@Service
public class AdministratorNewCategoryListService implements AbstractListService<Administrator, NewCategory> {

	@Autowired
	AdministratorNewCategoryRepository repository;


	@Override
	public boolean authorise(final Request<NewCategory> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<NewCategory> request, final NewCategory entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "categories");

	}

	@Override
	public Collection<NewCategory> findMany(final Request<NewCategory> request) {
		assert request != null;

		Collection<NewCategory> result = repository.findMany();

		return result;
	}

}
