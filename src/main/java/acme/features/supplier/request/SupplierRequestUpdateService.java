
package acme.features.supplier.request;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.configuration.SpamUtils;
import acme.entities.roles.Supplier;
import acme.enumeration.Process;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractUpdateService;

@Service
public class SupplierRequestUpdateService implements AbstractUpdateService<Supplier, acme.entities.requests.Request> {

	@Autowired
	SupplierRequestRepository	repository;

	@Autowired
	private SpamUtils			spamUtils;


	@Override
	public boolean authorise(Request<acme.entities.requests.Request> request) {
		assert request != null;

		int supplierPrincipalId = request.getPrincipal().getActiveRoleId();
		acme.entities.requests.Request _request = repository.findOneById(request.getModel().getInteger("id"));

		if (_request.getItem().getSupplier().getId() != supplierPrincipalId)
			return false;

		return true;
	}

	@Override
	public void bind(Request<acme.entities.requests.Request> request, acme.entities.requests.Request entity,
		Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
	}

	@Override
	public void unbind(Request<acme.entities.requests.Request> request, acme.entities.requests.Request entity,
		Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "ticker", "creationMoment", "item.title", "buyer.email", "quantity", "notes",
			"item.isNew", "process", "justification");
	}

	@Override
	public acme.entities.requests.Request findOne(Request<acme.entities.requests.Request> request) {
		assert request != null;

		acme.entities.requests.Request result;
		int id = request.getModel().getInteger("id");
		result = repository.findOneById(id);

		return result;
	}

	@Override
	public void validate(Request<acme.entities.requests.Request> request, acme.entities.requests.Request entity,
		Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		
		if(entity.getProcess().equals(Process.REJECTED)) {
			errors.state(request, !entity.getJustification().isEmpty(),
				"justification", "supplier.request.form.errors.justification.empty");
		}
		errors.state(request, !spamUtils.checkSpam(entity.getJustification()), "justification", "acme.validation.spam",
			spamUtils.getThreshold(), spamUtils.getSpamWords());
		
		if(errors.hasErrors()) {
			request.getModel().setAttribute("process", Process.PENDING);
		}
	}

	@Override
	public void update(Request<acme.entities.requests.Request> request, acme.entities.requests.Request entity) {
		assert request != null;
		assert entity != null;

		repository.save(entity);
	}

}
