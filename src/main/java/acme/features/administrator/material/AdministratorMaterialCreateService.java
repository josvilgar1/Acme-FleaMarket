
package acme.features.administrator.material;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.materials.Material;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractCreateService;

@Service
public class AdministratorMaterialCreateService implements AbstractCreateService<Administrator, Material> {

	@Autowired
	AdministratorMaterialRepository repository;


	@Override
	public boolean authorise(Request<Material> request) {
		assert request != null;

		return true;
	}

	@Override
	public void bind(final Request<Material> request, final Material entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
	}

	@Override
	public void unbind(final Request<Material> request, final Material entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "description", "providerName", "homePage", "stars", "id");

	}

	@Override
	public Material instantiate(final Request<Material> request) {
		Material material;

		material = new Material();

		return material;
	}

	@Override
	public void validate(final Request<Material> request, final Material entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
	}

	@Override
	public void create(final Request<Material> request, final Material entity) {
		repository.save(entity);
	}

}
