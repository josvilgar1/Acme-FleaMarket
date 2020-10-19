
package acme.features.anonymous.advertisement;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.advertisements.Advertisement;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractListService;

@Service
public class AnonymousAdvertisementListService implements AbstractListService<Anonymous, Advertisement> {

	@Autowired
	AnonymousAdvertisementRepository repository;


	@Override
	public boolean authorise(Request<Advertisement> request) {
		assert request != null;
		return true;
	}

	@Override
	public void unbind(Request<Advertisement> request, Advertisement entity, Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "finalDate", "text");
	}

	@Override
	public Collection<Advertisement> findMany(Request<Advertisement> request) {
		assert request != null;

		Collection<Advertisement> result;

		result = repository.findManyAll();

		return result;
	}

}
