
package acme.features.authenticated.messages;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.messages.Message;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractListService;

@Service
public class AuthenticatedMessageListService implements AbstractListService<Authenticated, Message> {

	@Autowired
	AuthenticatedMessageRepository repository;


	@Override
	public boolean authorise(Request<Message> request) {
		assert request != null;
		//TODO: must be authenticated
		return true;
	}

	@Override
	public void unbind(Request<Message> request, Message entity, Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "creationMoment", "authenticated.identity.name");
	}

	@Override
	public Collection<Message> findMany(Request<Message> request) {
		assert request != null;

		int itemId;

		itemId = request.getModel().getInteger("itemId");

		Collection<Message> result;
		result = repository.findManyByItemId(itemId);

		return result;
	}

}
