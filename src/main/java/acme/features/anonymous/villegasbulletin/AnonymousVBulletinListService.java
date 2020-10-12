
package acme.features.anonymous.villegasbulletin;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.villegasbulletin.Villegasbulletin;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractListService;

@Service
public class AnonymousVBulletinListService implements AbstractListService<Anonymous, Villegasbulletin> {

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

		request.unbind(entity, model, "date", "author", "title", "latitude", "longitude");
	}

	@Override
	public Collection<Villegasbulletin> findMany(final Request<Villegasbulletin> request) {
		assert request != null;

		Collection<Villegasbulletin> result;
		result = repository.findMany();

		return result;
	}

}
