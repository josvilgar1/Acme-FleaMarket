
package acme.features.authenticated.section;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.sections.Section;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractListService;

@Service
public class AuthenticatedSectionListService implements AbstractListService<Authenticated, Section> {

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

		request.unbind(entity, model, "index", "title", "item.title");
	}

	@Override
	public Collection<Section> findMany(Request<Section> request) {
		assert request != null;

		int itemId = request.getModel().getInteger("item.id");
		Collection<Section> result = repository.findManyByItemId(itemId);

		return result;
	}

}
