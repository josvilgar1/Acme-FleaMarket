
package acme.features.authenticated.material;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.materials.Material;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractShowService;

@Service
public class AuthenticatedMaterialShowService implements AbstractShowService<Authenticated, Material> {

	@Autowired
	AuthenticatedMaterialRepository repository;


	@Override
	public boolean authorise(Request<Material> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(Request<Material> request, Material entity, Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "description", "providerName", "homePage", "stars");
	}

	@Override
	public Material findOne(Request<Material> request) {
		assert request != null;

		Material result;

		int id = request.getModel().getInteger("id");
		result = repository.findOneById(id);

		return result;
	}

}
