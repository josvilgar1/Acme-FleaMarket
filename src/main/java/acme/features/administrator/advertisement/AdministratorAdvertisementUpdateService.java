
package acme.features.administrator.advertisement;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.advertisements.Advertisement;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractUpdateService;

@Service
public class AdministratorAdvertisementUpdateService implements AbstractUpdateService<Administrator, Advertisement> {

	@Autowired
	AdministratorAdvertisementRepository repository;


	@Override
	public boolean authorise(Request<Advertisement> request) {
		assert request != null;
		return true;
	}

	@Override
	public void bind(Request<Advertisement> request, Advertisement entity, Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "moment");
	}

	@Override
	public void unbind(Request<Advertisement> request, Advertisement entity, Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		request.unbind(entity, model, "title", "picture", "inicialDate", "finalDate", "text", "volumeDiscounts");
	}

	@Override
	public Advertisement findOne(Request<Advertisement> request) {
		assert request != null;

		Advertisement advertisement;

		int id;
		id = request.getModel().getInteger("id");

		advertisement = repository.findOneAdvertisementById(id);

		return advertisement;
	}

	@Override
	public void validate(Request<Advertisement> request, Advertisement entity, Errors errors) {
		//TODO: Falta validar que estemos en el plazo de display
		assert request != null;
		assert entity != null;
		assert errors != null;

		Date moment = new Date(System.currentTimeMillis());
		if (!entity.getInicialDate().before(moment) || !entity.getFinalDate().after(moment)) {

		}
	}

	@Override
	public void update(Request<Advertisement> request, Advertisement entity) {
		repository.save(entity);

	}

}
