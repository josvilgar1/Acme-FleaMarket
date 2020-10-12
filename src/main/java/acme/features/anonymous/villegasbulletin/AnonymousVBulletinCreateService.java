
package acme.features.anonymous.villegasbulletin;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.villegasbulletin.Villegasbulletin;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractCreateService;

@Service
public class AnonymousVBulletinCreateService implements AbstractCreateService<Anonymous, Villegasbulletin> {

	@Autowired
	AnonymousVBulletinRepository repository;


	@Override
	public boolean authorise(final Request<Villegasbulletin> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<Villegasbulletin> request, final Villegasbulletin entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "author", "title", "latitude", "longitude");

	}

	@Override
	public void bind(final Request<Villegasbulletin> request, final Villegasbulletin entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
	}

	@Override
	public Villegasbulletin instantiate(final Request<Villegasbulletin> request) {
		assert request != null;

		Villegasbulletin result;
		Date date;

		date = new Date(System.currentTimeMillis() - 1);
		result = new Villegasbulletin();
		result.setAuthor("Villegas");
		result.setTitle("First Bulletin!");
		result.setDate(date);
		result.setLongitude(0d);
		result.setLatitude(0d);

		return result;
	}

	@Override
	public void validate(final Request<Villegasbulletin> request, final Villegasbulletin entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
	}

	@Override
	public void create(final Request<Villegasbulletin> request, final Villegasbulletin entity) {
		assert request != null;
		assert entity != null;

		Date date;

		date = new Date(System.currentTimeMillis() - 1);
		entity.setDate(date);

		repository.save(entity);
	}
}
