
package acme.features.administrator.figment;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.figments.Figment;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractCreateService;

@Service
public class AdministratorFigmentCreateService implements AbstractCreateService<Administrator, Figment> {

	@Autowired
	AdministratorFigmentRepository repository;


	@Override
	public boolean authorise(Request<Figment> request) {
		assert request != null;

		return true;
	}

	@Override
	public void bind(final Request<Figment> request, final Figment entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "moment");
	}

	@Override
	public void unbind(final Request<Figment> request, final Figment entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "inventor", "moment", "description", "rangeMin", "rangeMax");

	}

	@Override
	public Figment instantiate(final Request<Figment> request) {
		Figment figment;

		figment = new Figment();

		return figment;
	}

	@Override
	public void validate(final Request<Figment> request, final Figment entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		if (!errors.hasErrors("rangeMax") && !errors.hasErrors("rangeMin")) {
			//Check if currency is in EUR-----------------------------------------------------
			Boolean maxIsEur = entity.getRangeMax().getCurrency().equals("EUR")
				|| entity.getRangeMax().getCurrency().equals("€");
			Boolean minIsEur = entity.getRangeMin().getCurrency().equals("EUR")
				|| entity.getRangeMin().getCurrency().equals("€");
			errors.state(request, maxIsEur, "rangeMax", "administrator.form.figment.errors.rangeMax.currency");
			errors.state(request, minIsEur, "rangeMin", "administrator.form.figment.errors.rangeMin.currency");

			if (maxIsEur && minIsEur)
				//Check rangeMax > rangeMin-------------------------------------------------------
				errors.state(request, entity.getRangeMax().getAmount() >= entity.getRangeMin().getAmount(), "rangeMin",
					"administrator.form.figment.errors.maxbiggerthanmin");

		}
	}

	@Override
	public void create(final Request<Figment> request, final Figment entity) {
		assert request != null;
		assert entity != null;

		Date moment;
		moment = new Date(System.currentTimeMillis() - 1);
		entity.setMoment(moment);
		repository.save(entity);
	}
}
