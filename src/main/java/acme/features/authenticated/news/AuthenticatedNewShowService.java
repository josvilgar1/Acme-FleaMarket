
package acme.features.authenticated.news;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.news.New;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractShowService;

@Service
public class AuthenticatedNewShowService implements AbstractShowService<Authenticated, New> {

	@Autowired
	AuthenticatedNewRepository repository;


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

		request.unbind(entity, model, "category", "headerPicture", "title", "creationMoment", "deadlineMoment", "body",
			"links");
	}

	@Override
	public New findOne(Request<New> request) {
		assert request != null;

		New result;
		int id;

		id = request.getModel().getInteger("id");
		result = repository.findOneById(id);

		return result;
	}

}
