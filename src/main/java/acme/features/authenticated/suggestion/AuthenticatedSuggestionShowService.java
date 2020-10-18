
package acme.features.authenticated.suggestion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.suggestions.Suggestion;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractShowService;

@Service
public class AuthenticatedSuggestionShowService implements AbstractShowService<Authenticated, Suggestion> {

	@Autowired
	AuthenticatedSuggestionRepository repository;


	@Override
	public boolean authorise(Request<Suggestion> request) {
		assert request != null;
		return true;
	}

	@Override
	public void unbind(Request<Suggestion> request, Suggestion entity, Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "creationMoment", "text", "email");
	}

	@Override
	public Suggestion findOne(Request<Suggestion> request) {
		assert request != null;

		Suggestion result;
		int id;

		id = request.getModel().getInteger("id");
		result = repository.findOneById(id);

		return result;
	}

}
