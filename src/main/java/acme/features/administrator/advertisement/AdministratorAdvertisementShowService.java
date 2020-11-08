
package acme.features.administrator.advertisement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.advertisements.Advertisement;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractShowService;

@Service
public class AdministratorAdvertisementShowService implements AbstractShowService<Administrator, Advertisement> {

	@Autowired
	AdministratorAdvertisementRepository repository;


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

		request.unbind(entity, model, "title", "picture", "moment", "inicialDate", "finalDate", "text",
			"volumeDiscounts");
	}

	@Override
	public Advertisement findOne(Request<Advertisement> request) {
		Advertisement advertisement;

		int id;
		id = request.getModel().getInteger("id");

		advertisement = repository.findOneAdvertisementById(id);

		return advertisement;
	}

}
