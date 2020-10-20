
package acme.features.authenticated.news;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.news.New;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractListService;

@Service
public class AuthenticatedNewListActiveService implements AbstractListService<Authenticated, New> {

	@Autowired
	AuthenticatedNewRepository repository;


	@Override
	public boolean authorise(Request<New> request) {
		assert request != null;
		return true;
	}

	@Override
	public void unbind(Request<New> request, New entity, Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "category", "title", "creationMoment", "deadlineMoment");
	}

	@Override
	public Collection<New> findMany(Request<New> request) {
		assert request != null;

		Collection<New> result;

		result = repository.findActive();

		return result;
	}

}
