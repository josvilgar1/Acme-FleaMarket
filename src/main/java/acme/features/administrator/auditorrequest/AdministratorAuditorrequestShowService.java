
package acme.features.administrator.auditorrequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.auditorrequests.Auditorrequest;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractShowService;

@Service
public class AdministratorAuditorrequestShowService implements AbstractShowService<Administrator, Auditorrequest> {

	@Autowired
	private AdministratorAuditorrequestRepository repository;


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

		request.unbind(entity, model, "firm", "responsibility", "authenticated.userAccount.Username");

	}

	@Override
	public Auditorrequest findOne(final Request<Auditorrequest> request) {
		assert request != null;

		Auditorrequest result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);

		return result;
	}
}
