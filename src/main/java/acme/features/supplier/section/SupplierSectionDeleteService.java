
package acme.features.supplier.section;

import java.util.Hashtable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.roles.Supplier;
import acme.entities.sections.Section;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.components.Response;
import acme.framework.services.AbstractDeleteService;

@Service
public class SupplierSectionDeleteService implements AbstractDeleteService<Supplier, Section> {

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
	public void bind(Request<Section> request, Section entity, Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
	}

	@Override
	public void unbind(Request<Section> request, Section entity, Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model);
	}

	@Override
	public Section findOne(Request<Section> request) {
		assert request != null;

		int id = request.getModel().getInteger("id");
		Section section = repository.findOneById(id);

		return section;
	}

	@Override
	public void validate(Request<Section> request, Section entity, Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		errors.state(request, repository.findAllRequestByItemId(entity.getItem().getId()).isEmpty(), "haveErrors",
			"supplier.section.form.errors.have.request");

		if (errors.hasErrors("haveErrors")) {
			Hashtable<String, Object> properties = new Hashtable<>();
			properties.put("status", entity.getItem().getStatus());
			properties.put("item.title", entity.getItem().getTitle());
			toMapAttributes(request, entity, properties);
		}
	}

	@Override
	public void delete(Request<Section> request, Section entity) {
		assert request != null;
		assert entity != null;

		repository.delete(entity);
	}

	@Override
	public void onSuccess(final Request<Section> request, final Response<Section> response) {
		response.setView("redirect:/supplier/item/list");
	}

}
