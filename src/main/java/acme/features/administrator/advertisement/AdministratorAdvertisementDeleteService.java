
package acme.features.administrator.advertisement;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.advertisements.Advertisement;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractDeleteService;

@Service
public class AdministratorAdvertisementDeleteService implements AbstractDeleteService<Administrator, Advertisement> {

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
		//TODO: asegurar que estamos en el periodo de display
		assert request != null;
		assert entity != null;
		assert errors != null;

		Calendar calendar;
		Boolean isInDisplayPeriod;

		calendar = new GregorianCalendar();
		Date calendarDate = calendar.getTime();
		isInDisplayPeriod = entity.getInicialDate().before(calendarDate) && entity.getFinalDate().after(calendarDate);

		errors.state(request, isInDisplayPeriod, "inicialDate", "administrator.form.advertisement.error.outOfPeriod");
	}

	@Override
	public void delete(Request<Advertisement> request, Advertisement entity) {
		repository.delete(entity);

	}
}
