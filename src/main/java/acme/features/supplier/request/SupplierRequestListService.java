
package acme.features.supplier.request;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.roles.Supplier;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractListService;

@Service
public class SupplierRequestListService implements AbstractListService<Supplier, acme.entities.requests.Request> {

	@Autowired
	SupplierRequestRepository repository;


	@Override
	public boolean authorise(Request<acme.entities.requests.Request> request) {
		assert request != null;
		return true;
	}

	@Override
	public void unbind(Request<acme.entities.requests.Request> request, acme.entities.requests.Request entity,
		Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "ticker", "item.title", "buyer.email", "quantity");
	}

	@Override
	public Collection<acme.entities.requests.Request> findMany(Request<acme.entities.requests.Request> request) {
		assert request != null;

		Collection<acme.entities.requests.Request> result;
		Integer id = request.getPrincipal().getActiveRoleId();
		result = repository.findMyAll(id);

		return result;
	}

}
