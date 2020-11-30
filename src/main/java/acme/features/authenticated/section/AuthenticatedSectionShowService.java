
package acme.features.authenticated.section;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.sections.Section;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractShowService;

@Service
public class AuthenticatedSectionShowService implements AbstractShowService<Authenticated, Section> {

	@Autowired
	AuthenticatedSectionRepository repository;


	@Override
	public boolean authorise(Request<Section> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(Request<Section> request, Section entity, Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "index", "title", "item.title", "description", "photo");
	}

	@Override
	public Section findOne(Request<Section> request) {
		assert request != null;

		Section result;

		int id = request.getModel().getInteger("id");
		result = repository.findOneById(id);

		return result;
	}

}
