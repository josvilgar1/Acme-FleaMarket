
package acme.features.administrator.newCategory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.configuration.NewCategory;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractUpdateService;

@Service
public class AdministratorNewCategoryUpdateService implements AbstractUpdateService<Administrator, NewCategory> {

	@Autowired
	AdministratorNewCategoryRepository repository;


	@Override
	public boolean authorise(final Request<NewCategory> request) {
		assert request != null;

		return true;
	}

	@Override
	public void bind(final Request<NewCategory> request, final NewCategory entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
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

	@Override
	public void validate(final Request<NewCategory> request, final NewCategory entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
	}

	@Override
	public void update(final Request<NewCategory> request, final NewCategory entity) {
		assert request != null;
		assert entity != null;

		repository.save(entity);
	}

}
