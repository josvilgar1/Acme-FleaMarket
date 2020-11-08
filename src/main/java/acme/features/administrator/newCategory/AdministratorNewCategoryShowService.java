
package acme.features.administrator.newCategory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.configuration.NewCategory;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractShowService;

@Service
public class AdministratorNewCategoryShowService implements AbstractShowService<Administrator, NewCategory> {

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
	public NewCategory findOne(final Request<NewCategory> request) {
		assert request != null;

		NewCategory NewCategory;
		int id = request.getModel().getInteger("id");

		NewCategory = repository.findOneNewCategoryById(id);

		return NewCategory;
	}

}
