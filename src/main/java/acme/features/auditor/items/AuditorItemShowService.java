
package acme.features.auditor.items;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.items.Item;
import acme.entities.roles.Auditor;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractShowService;

@Service
public class AuditorItemShowService implements AbstractShowService<Auditor, Item> {

	@Autowired
	AuditorItemRepository repository;


	@Override
	public boolean authorise(Request<Item> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(Request<Item> request, Item entity, Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "id", "ticker", "creationMoment", "title", "itemCategory", "description", "price",
			"photo", "link");
	}

	@Override
	public Item findOne(Request<Item> request) {
		assert request != null;

		Item result;
		int id = request.getModel().getInteger("id");
		result = repository.findOneById(id);

		return result;
	}
}
