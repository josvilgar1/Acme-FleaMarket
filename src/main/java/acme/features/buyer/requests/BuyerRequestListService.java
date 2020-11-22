
package acme.features.buyer.requests;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.requests.Request;
import acme.entities.roles.Buyer;
import acme.framework.components.Model;
import acme.framework.services.AbstractListService;

@Service
public class BuyerRequestListService implements AbstractListService<Buyer, Request> {

	@Autowired
	BuyerRequestRepository repository;


	@Override
	public boolean authorise(acme.framework.components.Request<Request> request) {
		assert request != null;
		return true;
	}

	@Override
	public void unbind(acme.framework.components.Request<Request> request, Request entity, Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "ticker", "item.title", "buyer.email", "quantity");
	}

	@Override
	public Collection<Request> findMany(acme.framework.components.Request<Request> request) {
		assert request != null;

		Collection<acme.entities.requests.Request> result;
		Integer id = request.getPrincipal().getActiveRoleId();
		result = repository.findMyAll(id);

		return result;
	}

}
