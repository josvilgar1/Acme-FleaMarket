
package acme.features.authenticated.advertisement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.advertisements.Advertisement;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractShowService;

@Service
public class AuthenticatedAdvertisementShowService implements AbstractShowService<Authenticated, Advertisement> {

	@Autowired
	AuthenticatedAdvertisementRepository repository;


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

		request.unbind(entity, model, "title", "picture", "moment", "inicialDate", "finalDate", "text", "volumeDiscounts");
	}

	@Override
	public Advertisement findOne(Request<Advertisement> request) {
		assert request != null;

		Advertisement result;

		int id = request.getModel().getInteger("id");
		result = repository.findOneById(id);

		return result;
	}
}
