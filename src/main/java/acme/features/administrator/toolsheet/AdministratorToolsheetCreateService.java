
package acme.features.administrator.toolsheet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.toolsheets.Toolsheet;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractCreateService;

@Service
public class AdministratorToolsheetCreateService implements AbstractCreateService<Administrator, Toolsheet> {

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
	public Toolsheet instantiate(final Request<Toolsheet> request) {
		Toolsheet result;

		result = new Toolsheet();

		return result;
	}

	@Override
	public void validate(final Request<Toolsheet> request, final Toolsheet entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
	}

	@Override
	public void create(final Request<Toolsheet> request, final Toolsheet entity) {
		assert request != null;
		assert entity != null;

		repository.save(entity);
	}
}
