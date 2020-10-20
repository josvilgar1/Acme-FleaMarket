
package acme.features.authenticated.material;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.materials.Material;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractListService;

@Service
public class AuthenticatedMaterialListService implements AbstractListService<Authenticated, Material> {

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

		request.unbind(entity, model, "title", "providerName", "stars");
	}

	@Override
	public Collection<Material> findMany(Request<Material> request) {
		assert request != null;

		Collection<Material> result;

		result = repository.findManyAll();

		return result;
	}

}
