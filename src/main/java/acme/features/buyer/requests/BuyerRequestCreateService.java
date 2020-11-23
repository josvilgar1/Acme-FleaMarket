
package acme.features.buyer.requests;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.items.Item;
import acme.entities.requests.Request;
import acme.entities.roles.Buyer;
import acme.framework.components.Errors;
import acme.framework.components.HttpMethod;
import acme.framework.components.Model;
import acme.framework.components.Response;
import acme.framework.entities.Principal;
import acme.framework.helpers.PrincipalHelper;
import acme.framework.services.AbstractCreateService;

@Service
public class BuyerRequestCreateService implements AbstractCreateService<Buyer, Request> {

	@Autowired
	private BuyerRequestRepository repository;


	@Override
	public boolean authorise(final acme.framework.components.Request<Request> request) {
		assert request != null;

		return true;
	}

	@Override
	public void validate(final acme.framework.components.Request<Request> request, final Request entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

	}

	@Override
	public void bind(final acme.framework.components.Request<Request> request, final Request entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
	}

	@Override
	public void unbind(final acme.framework.components.Request<Request> request, final Request entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "ticker", "quantity", "notes");
	}

	@Override
	public Request instantiate(final acme.framework.components.Request<Request> request) {
		assert request != null;

		Request result = new Request();
		Principal principal;
		Buyer buyer;
		Item item;
		int itemId;

		principal = request.getPrincipal();
		buyer = repository.findUserById(principal.getAccountId());

		itemId = request.getModel().getInteger("itemId");
		item = repository.findItemById(itemId);

		result.setBuyer(buyer);
		result.setItem(item);

		return result;
	}

	@Override
	public void create(final acme.framework.components.Request<Request> request, final Request entity) {
		assert request != null;
		assert entity != null;

		Date moment;

		moment = new Date(System.currentTimeMillis() - 1);
		entity.setCreationMoment(moment);
		repository.save(entity);
	}

	@Override
	public void onSuccess(final acme.framework.components.Request<Request> request, final Response<Request> response) {
		assert request != null;
		assert response != null;

		if (request.isMethod(HttpMethod.POST))
			PrincipalHelper.handleUpdate();
	}

}
