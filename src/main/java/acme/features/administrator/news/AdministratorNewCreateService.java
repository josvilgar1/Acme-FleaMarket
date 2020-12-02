
package acme.features.administrator.news;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.news.New;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractCreateService;

@Service
public class AdministratorNewCreateService implements AbstractCreateService<Administrator, New> {

	@Autowired
	AdministratorNewRepository repository;


	@Override
	public boolean authorise(final Request<New> request) {
		assert request != null;

		return true;
	}

	@Override
	public void bind(final Request<New> request, final New entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.transfer(request.getModel(), "confirmation");
		request.bind(entity, errors, "creationMoment");
	}

	@Override
	public void unbind(final Request<New> request, final New entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		model.setAttribute("confirmation", false);
		request.unbind(entity, model, "category", "headerPicture", "title", "creationMoment", "deadlineMoment", "body",
			"links");
	}

	@Override
	public New instantiate(final Request<New> request) {
		New result;

		result = new New();

		return result;
	}

	@Override
	public void validate(final Request<New> request, final New entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		if (!errors.hasErrors("confirmation"))
			errors.state(request, request.getModel().getBoolean("confirmation"), "confirmation",
				"administrator.new.form.errors.confirmation");

		if (!errors.hasErrors("deadlineMoment")) {
			//Check if deadline is in future------------------------------------------------------
			Calendar calendar = Calendar.getInstance();
			errors.state(request, entity.getDeadlineMoment().after(calendar.getTime()), "deadlineMoment",
				"authenticated.buyer.form.errors.creditCardMonth");
		}

	}

	@Override
	public void create(final Request<New> request, final New entity) {
		assert request != null;
		assert entity != null;

		Date moment;
		moment = new Date(System.currentTimeMillis() - 1);
		entity.setCreationMoment(moment);
		repository.save(entity);

	}
}
