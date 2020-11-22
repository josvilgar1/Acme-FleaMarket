
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

		return true;
	}

	@Override
	public void unbind(acme.framework.components.Request<Request> request, Request entity, Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "id", "ticker", "creationMoment", "title", "itemCategory", "description", "price", "photo", "link");
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
