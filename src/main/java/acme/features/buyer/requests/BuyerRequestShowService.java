
package acme.features.buyer.requests;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.requests.Request;
import acme.entities.roles.Buyer;
import acme.framework.components.Model;
import acme.framework.services.AbstractShowService;

@Service
public class BuyerRequestShowService implements AbstractShowService<Buyer, Request> {

	@Autowired
	BuyerRequestRepository repository;


	@Override
	public boolean authorise(acme.framework.components.Request<Request> request) {
		assert request != null;

		//TODO: must check buyer request is the same as logged and principal is Buyer

		return true;
	}

	@Override
	public void unbind(acme.framework.components.Request<Request> request, Request entity, Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "ticker", "creationMoment", "quantity", "notes", "buyer.email", "item.title");
	}

	@Override
	public Request findOne(acme.framework.components.Request<Request> request) {
		assert request != null;

		Request result;
		int id = request.getModel().getInteger("id");
		result = repository.findOneById(id);

		return result;
	}
}
