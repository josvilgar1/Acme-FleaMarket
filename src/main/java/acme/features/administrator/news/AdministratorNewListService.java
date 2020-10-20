
package acme.features.administrator.news;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.news.New;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractListService;

@Service
public class AdministratorNewListService implements AbstractListService<Administrator, New> {

	@Autowired
	AdministratorNewRepository repository;


	@Override
	public boolean authorise(Request<New> request) {
		assert request != null;
		return true;
	}

	@Override
	public void unbind(Request<New> request, New entity, Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "category", "title", "creationMoment", "deadlineMoment");
	}

	@Override
	public Collection<New> findMany(Request<New> request) {
		assert request != null;

		Collection<New> result;

		result = repository.findMany();

		return result;
	}

}
