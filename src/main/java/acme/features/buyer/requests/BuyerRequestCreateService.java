
package acme.features.buyer.requests;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.configuration.SpamUtils;
import acme.entities.items.Item;
import acme.entities.requests.Request;
import acme.entities.roles.Buyer;
import acme.enumeration.Process;
import acme.enumeration.Status;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.services.AbstractCreateService;

@Service
public class BuyerRequestCreateService implements AbstractCreateService<Buyer, Request> {

	@Autowired
	BuyerRequestRepository	repository;

	@Autowired
	SpamUtils				spamUtils;


	@Override
	public boolean authorise(acme.framework.components.Request<Request> request) {
		assert request != null;

		return true;
	}

	@Override
	public void bind(acme.framework.components.Request<Request> request, Request entity, Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
	}

	@Override
	public void unbind(acme.framework.components.Request<Request> request, Request entity, Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		model.setAttribute("itemHasXxx", !repository.findXxxByItemId(entity.getItem().getId()).isEmpty());
		request.unbind(entity, model, "quantity", "notes", "buyer", "justification", "process", "item.id", "item.title",
			"xxxResponse", "xxxLink", "password");
	}

	@Override
	public Request instantiate(acme.framework.components.Request<Request> request) {
		Request result = new Request();
		int principalId = request.getPrincipal().getAccountId();
		Buyer buyer = repository.findBuyerByUserAccount(principalId);

		Integer itemId = request.getModel().getInteger("item.id");
		if (itemId == null)
			itemId = request.getModel().getInteger("itemId");

		Item item = repository.findItemById(itemId);

		result.setBuyer(buyer);
		result.setItem(item);
		result.setProcess(Process.PENDING);

		return result;
	}

	@Override
	public void validate(acme.framework.components.Request<Request> request, Request entity, Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		//Check Spam
		errors.state(request, !spamUtils.checkSpam(entity.getNotes()), "title", "acme.validation.spam",
			spamUtils.getThreshold(), spamUtils.getSpamWords());

		errors.state(request, !spamUtils.checkSpam(entity.getXxxResponse()), "xxxResponse", "acme.validation.spam",
			spamUtils.getThreshold(), spamUtils.getSpamWords());

		//Check Item is in FinalMode
		errors.state(request, entity.getItem().getStatus() != Status.DRAFT, "haveErrors",
			"buyer.request.form.errors.status.notPublished");

		if (!errors.hasErrors("password"))
			errors.state(request, !entity.getXxxLink().isEmpty() && entity.getPassword().isEmpty(), "password",
				"buyer.request.form.errors.password");
	}

	@Override
	public void create(acme.framework.components.Request<Request> request, Request entity) {
		assert request != null;
		assert entity != null;

		//GENERATE CREATION MOMENT-----------------------------------
		Date creationMoment;

		creationMoment = new Date(System.currentTimeMillis() - 1);
		entity.setCreationMoment(creationMoment);
		//-----------------------------------------------------------

		//GENERATE TICKER -------------------------------------------
		String ticker;

		ticker = entity.generateTicker();

		//We must check if the ticker already exists in database
		Request requestByTicker = repository.findItemByTicker(ticker);
		while (requestByTicker != null) {
			ticker = entity.generateTicker();
			requestByTicker = repository.findItemByTicker(ticker);
		}
		//-----------------------------------------------------------

		entity.setTicker(ticker);

		entity.setProcess(Process.PENDING);

		repository.save(entity);
	}

}
