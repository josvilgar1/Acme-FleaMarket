
package acme.features.administrator.suggestion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.suggestions.Suggestion;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractDeleteService;

@Service
public class AdministratorSuggestionDeleteService implements AbstractDeleteService<Administrator, Suggestion> {

	@Autowired
	AdministratorSuggestionRepository repository;


	@Override
	public boolean authorise(final Request<Suggestion> request) {
		assert request != null;

		return true;
	}

	@Override
	public void bind(final Request<Suggestion> request, final Suggestion entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
	}

	@Override
	public void unbind(final Request<Suggestion> request, final Suggestion entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "creationMoment", "text", "email");
	}

	@Override
	public Suggestion findOne(final Request<Suggestion> request) {
		assert request != null;

		Suggestion result;
		int id;

		id = request.getModel().getInteger("id");
		result = repository.findOneById(id);

		return result;
	}

	@Override
	public void validate(final Request<Suggestion> request, final Suggestion entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
	}

	@Override
	public void delete(final Request<Suggestion> request, final Suggestion entity) {
		assert request != null;
		assert entity != null;

		repository.delete(entity);
	}

}
