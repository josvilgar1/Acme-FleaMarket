
package acme.features.buyer.requests;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.requests.Request;
import acme.entities.roles.Buyer;
import acme.framework.components.Model;
import acme.framework.services.AbstractListService;

@Service
public class BuyerRequestListMineService implements AbstractListService<Buyer, Request> {

	@Autowired
	BuyerRequestRepository repository;


	@Override
	public boolean authorise(acme.framework.components.Request<Request> request) {
		assert request != null;

		Integer user = request.getPrincipal().getActiveRoleId();

		//TODO: Must check is principal is buyer
		return true;

	}

	@Override
	public void unbind(acme.framework.components.Request<Request> request, Request entity, Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "ticker", "creationMoment", "quantity", "item.title");
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
