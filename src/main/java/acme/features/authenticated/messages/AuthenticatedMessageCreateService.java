
package acme.features.authenticated.messages;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.configuration.SpamUtils;
import acme.entities.forums.Forum;
import acme.entities.messages.Message;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractCreateService;

@Service
public class AuthenticatedMessageCreateService implements AbstractCreateService<Authenticated, Message> {

	@Autowired
	AuthenticatedMessageRepository	repository;

	@Autowired
	private SpamUtils				spamUtils;


	@Override
	public boolean authorise(final Request<Message> request) {
		assert request != null;

		int authId = request.getPrincipal().getActiveRoleId();
		Authenticated auth = repository.findAuthenticatedById(authId);

		return auth != null;
	}

	@Override
	public void bind(final Request<Message> request, final Message entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.transfer(request.getModel(), "confirm");
		request.bind(entity, errors, "creationMoment");
	}

	@Override
	public void unbind(final Request<Message> request, final Message entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		model.setAttribute("confirm", false);
		request.unbind(entity, model, "creationMoment", "title", "tags", "body", "forum.id");
	}

	@Override
	public Message instantiate(final Request<Message> request) {
		assert request != null;

		Principal principal;
		Forum forum;
		Integer itemId;
		Authenticated authenticated;
		Message result;

		principal = request.getPrincipal();
		itemId = request.getModel().getInteger("itemId");

		if (itemId == null) {
			Integer forumId = request.getModel().getInteger("forum.id");
			forum = repository.findForumById(forumId);
		} else
			forum = repository.findForumByItemId(itemId);

		authenticated = repository.findAuthenticatedById(principal.getActiveRoleId());

		result = new Message();

		result.setAuthenticated(authenticated);
		result.setForum(forum);

		return result;
	}

	@Override
	public void validate(final Request<Message> request, final Message entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		boolean confirmed;
		//1: Comprobar Confirmation == 'true'
		if (!errors.hasErrors("confirm")) {
			confirmed = request.getModel().getBoolean("confirm");
			errors.state(request, confirmed, "confirm", "forum.message.form.error.confirmation");
		}
		errors.state(request, !spamUtils.checkSpam(entity.getTitle()), "title", "acme.validation.spam",
			spamUtils.getThreshold(), spamUtils.getSpamWords());
		errors.state(request, !spamUtils.checkSpam(entity.getTags()), "tags", "acme.validation.spam",
			spamUtils.getThreshold(), spamUtils.getSpamWords());
		errors.state(request, !spamUtils.checkSpam(entity.getBody()), "body", "acme.validation.spam",
			spamUtils.getThreshold(), spamUtils.getSpamWords());
	}

	@Override
	public void create(final Request<Message> request, final Message entity) {
		assert request != null;
		assert entity != null;

		Date date = new Date(System.currentTimeMillis());
		Integer itemId;
		Integer forumId;
		Forum forum;
		Principal principal;

		principal = request.getPrincipal();
		itemId = request.getModel().getInteger("itemId");

		if (itemId == null) {
			forumId = request.getModel().getInteger("forum.id");
			forum = repository.findForumById(forumId);
		} else
			forum = repository.findForumByItemId(itemId);
		Authenticated authenticated = repository.findAuthenticatedById(principal.getActiveRoleId());

		entity.setAuthenticated(authenticated);
		entity.setForum(forum);
		entity.setCreationMoment(date);

		repository.save(entity);

	}

}
