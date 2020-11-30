
package acme.features.authenticated.messages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.messages.Message;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractShowService;

@Service
public class AuthenticatedMessageShowService implements AbstractShowService<Authenticated, Message> {

	@Autowired
	AuthenticatedMessageRepository repository;


	@Override
	public boolean authorise(Request<Message> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(Request<Message> request, Message entity, Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "creationMoment", "tags", "authenticated.identity.name",
			"forum.item.title", "body");
	}

	@Override
	public Message findOne(Request<Message> request) {
		assert request != null;

		Message result;

		int id = request.getModel().getInteger("id");
		result = repository.findOneById(id);

		return result;
	}

}
