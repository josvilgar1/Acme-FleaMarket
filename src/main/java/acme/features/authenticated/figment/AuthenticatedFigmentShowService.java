
package acme.features.authenticated.figment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.figments.Figment;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractShowService;

@Service
public class AuthenticatedFigmentShowService implements AbstractShowService<Authenticated, Figment> {

	@Autowired
	AuthenticatedFigmentRepository repository;


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

		request.unbind(entity, model, "title", "inventor", "moment", "description", "rangeMin", "rangeMax");
	}

	@Override
	public Figment findOne(Request<Figment> request) {
		assert request != null;

		Figment result;

		int id = request.getModel().getInteger("id");
		result = repository.findOneById(id);

		return result;
	}
}
