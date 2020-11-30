
package acme.features.authenticated.forum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.forums.Forum;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractShowService;

@Service
public class AuthenticatedForumShowService implements AbstractShowService<Authenticated, Forum> {

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

		model.setAttribute("itemId", entity.getItem().getId());
		request.unbind(entity, model, "title", "item.title");
	}

	@Override
	public Forum findOne(Request<Forum> request) {
		assert request != null;

		Forum result;

		int id = request.getModel().getInteger("id");
		result = repository.findOneById(id);

		return result;
	}

}
