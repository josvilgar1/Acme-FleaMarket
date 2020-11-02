
package acme.features.administrator.toolsheet;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.toolsheets.Toolsheet;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractListService;

@Service
public class AdministratorToolsheetListService implements AbstractListService<Administrator, Toolsheet> {

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

		request.unbind(entity, model, "title", "description", "providerName", "stars");
	}

	@Override
	public Collection<Toolsheet> findMany(Request<Toolsheet> request) {
		assert request != null;

		Collection<Toolsheet> result;

		result = repository.findMany();

		return result;
	}

}
