
package acme.features.administrator.toolsheet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.toolsheets.Toolsheet;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractUpdateService;

@Service
public class AdministratorToolsheetUpdateService implements AbstractUpdateService<Administrator, Toolsheet> {

	@Autowired
	AdministratorToolsheetRepository repository;


	@Override
	public boolean authorise(final Request<Toolsheet> request) {
		assert request != null;

		return true;
	}

	@Override
	public void bind(final Request<Toolsheet> request, final Toolsheet entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
	}

	@Override
	public void unbind(final Request<Toolsheet> request, final Toolsheet entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "description", "providerName", "stars");
	}

	@Override
	public Toolsheet findOne(final Request<Toolsheet> request) {
		assert request != null;

		Toolsheet result;
		int id;

		id = request.getModel().getInteger("id");
		result = repository.findOneById(id);

		return result;
	}

	@Override
	public void validate(final Request<Toolsheet> request, final Toolsheet entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
	}

	@Override
	public void update(final Request<Toolsheet> request, final Toolsheet entity) {
		assert request != null;
		assert entity != null;

		repository.save(entity);
	}
}
