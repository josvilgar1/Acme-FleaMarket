
package acme.features.administrator.auditorrequest;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.auditorrequests.Auditorrequest;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractListService;

@Service
public class AdministratorAuditorrequestListService implements AbstractListService<Administrator, Auditorrequest> {

	@Autowired
	AdministratorAuditorrequestRepository repository;


	@Override
	public boolean authorise(final Request<Auditorrequest> request) {
		assert request != null;
		return true;
	}

	@Override
	public void unbind(final Request<Auditorrequest> request, final Auditorrequest entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "firm", "responsibility");

	}

	@Override
	public Collection<Auditorrequest> findMany(final Request<Auditorrequest> request) {
		assert request != null;

		Collection<Auditorrequest> result;

		result = this.repository.findMany();

		return result;
	}

}
