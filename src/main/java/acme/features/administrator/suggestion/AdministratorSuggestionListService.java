
package acme.features.administrator.suggestion;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.suggestions.Suggestion;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractListService;

@Service
public class AdministratorSuggestionListService implements AbstractListService<Administrator, Suggestion> {

	@Autowired
	AdministratorSuggestionRepository repository;


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

		request.unbind(entity, model, "title", "creationMoment");
	}

	@Override
	public Collection<Suggestion> findMany(Request<Suggestion> request) {
		assert request != null;

		Collection<Suggestion> result;

		result = repository.findMany();

		return result;
	}

}
