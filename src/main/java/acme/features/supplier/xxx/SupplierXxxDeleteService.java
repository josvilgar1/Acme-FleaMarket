
package acme.features.supplier.xxx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.roles.Supplier;
import acme.entities.xxx.Xxx;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractDeleteService;

@Service
public class SupplierXxxDeleteService implements AbstractDeleteService<Supplier, Xxx> {

	@Autowired
	SupplierXxxRepository repository;


	@Override
	public boolean authorise(Request<Xxx> request) {
		assert request != null;

		int supplierPrincipalId = request.getPrincipal().getActiveRoleId();
		Xxx xxx = repository.findOneById(request.getModel().getInteger("id"));

		if (xxx.getItem().getSupplier().getId() != supplierPrincipalId)
			return false;

		return true;
	}

	@Override
	public void bind(Request<Xxx> request, Xxx entity, Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
	}

	@Override
	public void unbind(Request<Xxx> request, Xxx entity, Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model);
	}

	@Override
	public Xxx findOne(Request<Xxx> request) {
		assert request != null;

		int id = request.getModel().getInteger("id");
		Xxx xxx = repository.findOneById(id);

		return xxx;
	}

	@Override
	public void validate(Request<Xxx> request, Xxx entity, Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

	}

	@Override
	public void delete(Request<Xxx> request, Xxx entity) {
		assert request != null;
		assert entity != null;

		repository.delete(entity);
	}

}
