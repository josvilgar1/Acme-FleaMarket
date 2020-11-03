
package acme.features.administrator.figment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.figments.Figment;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractShowService;

@Service
public class AdministratorFigmentShowService implements AbstractShowService<Administrator, Figment> {

	@Autowired
	AdministratorFigmentRepository repository;


	@Override
	public boolean authorise(Request<Figment> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(Request<Figment> request, Figment entity, Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "inventor", "description", "priceInterval");
	}

	@Override
	public Figment findOne(Request<Figment> request) {
		Figment figment;

		int id;
		id = request.getModel().getInteger("id");

		figment = repository.findOneFigmentById(id);

		return figment;
	}

}
