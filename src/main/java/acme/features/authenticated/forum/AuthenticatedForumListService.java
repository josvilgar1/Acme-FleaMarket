
package acme.features.authenticated.forum;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.forums.Forum;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractListService;

@Service
public class AuthenticatedForumListService implements AbstractListService<Authenticated, Forum> {

	@Autowired
	AuthenticatedForumRepository repository;


	@Override
	public boolean authorise(Request<Forum> request) {
		assert request != null;
		return true;
	}

	@Override
	public void unbind(Request<Forum> request, Forum entity, Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title");
	}

	@Override
	public Collection<Forum> findMany(Request<Forum> request) {
		assert request != null;

		Collection<Forum> result;
		result = repository.findManyAll();

		return result;
	}

}
