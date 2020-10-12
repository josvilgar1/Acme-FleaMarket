
package acme.features.anonymous.gamezbulletin;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.gamezbulletins.Gamezbulletin;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractListService;

@Service
public class AnonymousGamezbulletinListService implements AbstractListService<Anonymous, Gamezbulletin> {

	@Autowired
	AnonymousGamezbulletinRepository repository;


	@Override
	public boolean authorise(final Request<Gamezbulletin> request) {
		assert request != null;
		return true;
	}

	@Override
	public void unbind(final Request<Gamezbulletin> request, final Gamezbulletin entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "author", "age", "text", "moment", "creditCard");
	}

	@Override
	public Collection<Gamezbulletin> findMany(final Request<Gamezbulletin> request) {
		assert request != null;

		Collection<Gamezbulletin> result;
		result = repository.findMany();

		return result;
	}

}
