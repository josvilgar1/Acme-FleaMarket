
package acme.features.administrator.advertisement;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.advertisements.Advertisement;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractCreateService;

@Service
public class AdministratorAdvertisementCreateService implements AbstractCreateService<Administrator, Advertisement> {

	@Autowired
	AdministratorAdvertisementRepository repository;


	@Override
	public boolean authorise(Request<Advertisement> request) {
		assert request != null;

		return true;
	}

	@Override
	public void bind(final Request<Advertisement> request, final Advertisement entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "moment");
	}

	@Override
	public void unbind(final Request<Advertisement> request, final Advertisement entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "picture", "moment", "inicialDate", "finalDate", "text",
			"volumeDiscounts");

	}

	@Override
	public Advertisement instantiate(final Request<Advertisement> request) {
		Advertisement advertisement;

		advertisement = new Advertisement();

		return advertisement;
	}

	@Override
	public void validate(final Request<Advertisement> request, final Advertisement entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		//Check Display Period is not null
		if (!errors.hasErrors("finalDate") && !errors.hasErrors("inicialDate")) {
			Date moment = Calendar.getInstance().getTime();
			Date finalDate = entity.getFinalDate();
			Date inicialDate = entity.getInicialDate();

			Boolean inicialAfterMoment = inicialDate.after(moment);
			errors.state(request, inicialAfterMoment, "inicialDate",
				"administrator.form.advertisement.error.inicialAfterMoment");

			Boolean inicialBeforeFinal = inicialDate.before(finalDate);
			errors.state(request, inicialBeforeFinal, "inicialDate",
				"administrator.form.advertisement.error.inicialBeforeFinal");
		}

	}

	@Override
	public void create(final Request<Advertisement> request, final Advertisement entity) {
		assert request != null;
		assert entity != null;

		Date moment;
		moment = new Date(System.currentTimeMillis() - 1);
		entity.setMoment(moment);
		repository.save(entity);
	}
}
