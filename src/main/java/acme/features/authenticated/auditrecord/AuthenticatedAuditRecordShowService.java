
package acme.features.authenticated.auditrecord;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.auditrecords.AuditRecord;
import acme.enumeration.Status;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractShowService;

@Service
public class AuthenticatedAuditRecordShowService implements AbstractShowService<Authenticated, AuditRecord> {

	@Autowired
	AuthenticatedAuditRecordRepository repository;


	@Override
	public boolean authorise(Request<AuditRecord> request) {
		assert request != null;

		int id = request.getModel().getInteger("id");
		AuditRecord ar = repository.findOneById(id);
		if (!ar.getStatus().equals(Status.PUBLISHED))
			return false;

		return true;
	}

	@Override
	public void unbind(Request<AuditRecord> request, AuditRecord entity, Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "item.title", "title", "auditor.firm", "creationMoment", "body", "status");
	}

	@Override
	public AuditRecord findOne(Request<AuditRecord> request) {
		assert request != null;

		AuditRecord result;

		int id = request.getModel().getInteger("id");
		result = repository.findOneById(id);

		return result;
	}
}
