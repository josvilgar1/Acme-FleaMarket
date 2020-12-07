
package acme.features.authenticated.items;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.items.Item;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractListService;

@Service
public class AuthenticatedItemListService implements AbstractListService<Authenticated, Item> {

	@Autowired
	AuthenticatedItemRepository repository;


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

		request.unbind(entity, model, "title", "itemCategory", "price");
	}

	@Override
	public Collection<Item> findMany(Request<Item> request) {
		assert request != null;

		Collection<Item> result;
		result = repository.findManyPublishedItems();

		return result;
	}

}
