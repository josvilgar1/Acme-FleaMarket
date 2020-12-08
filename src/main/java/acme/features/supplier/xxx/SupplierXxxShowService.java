
package acme.features.supplier.xxx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.roles.Supplier;
import acme.entities.xxx.Xxx;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractShowService;

@Service
public class SupplierXxxShowService implements AbstractShowService<Supplier, Xxx> {

	@Autowired
	SupplierXxxRepository repository;


	@Override
	public boolean authorise(Request<Xxx> request) {
		assert request != null;

		int supplierPrincipalId = request.getPrincipal().getActiveRoleId();
		Xxx xxx = repository.findOneByItemId(request.getModel().getInteger("item.id"));

		if (xxx.getItem().getSupplier().getId() != supplierPrincipalId)
			return false;

		return true;
	}

	@Override
	public void unbind(Request<Xxx> request, Xxx entity, Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "text", "priceMin", "priceMax", "code", "item.title");
	}

	@Override
	public Xxx findOne(Request<Xxx> request) {
		assert request != null;

		Xxx result;

		int id = request.getModel().getInteger("item.id");
		result = repository.findOneByItemId(id);

		return result;
	}

}
