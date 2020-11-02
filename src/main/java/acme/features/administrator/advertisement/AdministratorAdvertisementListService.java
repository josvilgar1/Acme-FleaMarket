
package acme.features.administrator.advertisement;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.advertisements.Advertisement;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractListService;

@Service
public class AdministratorAdvertisementListService implements AbstractListService<Administrator, Advertisement> {

	@Autowired
	AdministratorAdvertisementRepository repository;


	@Override
	public boolean authorise(Request<Advertisement> request) {
		assert request != null;
		return true;
	}

	@Override
	public void unbind(Request<Advertisement> request, Advertisement entity, Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "inicialDate", "finalDate");
	}

	@Override
	public Collection<Advertisement> findMany(Request<Advertisement> request) {
		assert request != null;

		Collection<Advertisement> result = repository.findAllAdvertisement();

		return result;
	}
}
