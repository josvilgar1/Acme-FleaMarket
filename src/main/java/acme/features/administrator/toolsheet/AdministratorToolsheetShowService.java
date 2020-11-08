
package acme.features.administrator.toolsheet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.toolsheets.Toolsheet;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractShowService;

@Service
public class AdministratorToolsheetShowService implements AbstractShowService<Administrator, Toolsheet> {

	@Autowired
	AdministratorToolsheetRepository repository;


	@Override
	public boolean authorise(Request<Toolsheet> request) {
		assert request != null;
		return true;
	}

	@Override
	public void unbind(Request<Toolsheet> request, Toolsheet entity, Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "description", "providerName", "homePage", "stars");
	}

	@Override
	public Toolsheet findOne(Request<Toolsheet> request) {
		assert request != null;

		Toolsheet result;
		int id;

		id = request.getModel().getInteger("id");
		result = repository.findOneById(id);

		return result;
	}

}
