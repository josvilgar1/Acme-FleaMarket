
package acme.features.authenticated.figment;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.figments.Figment;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractListService;

@Service
public class AuthenticatedFigmentListService implements AbstractListService<Authenticated, Figment> {

	@Autowired
	AuthenticatedFigmentRepository repository;


	@Override
	public boolean authorise(Request<Figment> request) {
		assert request != null;
		return true;
	}

	@Override
	public void unbind(Request<Figment> request, Figment entity, Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "inventor", "description");
	}

	@Override
	public Collection<Figment> findMany(Request<Figment> request) {
		assert request != null;

		Collection<Figment> result;

		result = repository.findManyAll();

		return result;
	}

}
