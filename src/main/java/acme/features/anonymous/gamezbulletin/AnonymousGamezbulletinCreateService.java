
package acme.features.anonymous.gamezbulletin;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.gamezbulletins.Gamezbulletin;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractCreateService;

@Service
public class AnonymousGamezbulletinCreateService implements AbstractCreateService<Anonymous, Gamezbulletin> {

	@Autowired
	AnonymousGamezbulletinRepository repository;


	@Override
	public boolean authorise(final Request<Gamezbulletin> request) {
		assert request != null;

		return true;
	}

	@Override
	public void bind(final Request<Gamezbulletin> request, final Gamezbulletin entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
	}

	@Override
	public void unbind(final Request<Gamezbulletin> request, final Gamezbulletin entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "author", "age", "text", "creditCard");
	}

	@Override
	public Gamezbulletin instantiate(final Request<Gamezbulletin> request) {
		assert request != null;

		Gamezbulletin result;
		Date moment;

		moment = new Date(System.currentTimeMillis() - 1);
		result = new Gamezbulletin();
		result.setAuthor("Gamez");
		result.setAge(18);
		result.setText("Gamezbulletin");
		result.setMoment(moment);
		result.setCreditCard("1111222233334444");

		return result;
	}

	@Override
	public void validate(final Request<Gamezbulletin> request, final Gamezbulletin entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
	}

	@Override
	public void create(final Request<Gamezbulletin> request, final Gamezbulletin entity) {
		assert request != null;
		assert entity != null;

		Date moment;

		moment = new Date(System.currentTimeMillis() - 1);
		entity.setMoment(moment);

		repository.save(entity);

	}

}
