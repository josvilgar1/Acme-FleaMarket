
package acme.features.supplier.request;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.roles.Supplier;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractShowService;

@Service
public class SupplierRequestShowService implements AbstractShowService<Supplier, acme.entities.requests.Request> {

	@Autowired
	SupplierRequestRepository repository;


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

}
