
package acme.features.supplier.section;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.roles.Supplier;
import acme.entities.sections.Section;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractShowService;

@Service
public class SupplierSectionShowService implements AbstractShowService<Supplier, Section> {

	@Autowired
	SupplierSectionRepository repository;


	@Override
	public boolean authorise(Request<Section> request) {
		assert request != null;

		int supplierPrincipalId = request.getPrincipal().getActiveRoleId();
		Section section = repository.findOneById(request.getModel().getInteger("id"));

		if (section.getItem().getSupplier().getId() != supplierPrincipalId)
			return false;

		return true;
	}

	@Override
	public void unbind(Request<Section> request, Section entity, Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		model.setAttribute("status", entity.getItem().getStatus());
		request.unbind(entity, model, "item.id", "item.title", "index", "title", "description", "photo");
	}

	@Override
	public Section findOne(Request<Section> request) {
		assert request != null;

		Section result;

		int id = request.getModel().getInteger("id");
		result = repository.findOneById(id);

		return result;
	}

}
