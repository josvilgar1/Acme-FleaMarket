
package acme.features.auditor.auditrecords;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.auditrecords.AuditRecord;
import acme.entities.roles.Auditor;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractShowService;

@Service
public class AuditorAuditRecordShowService implements AbstractShowService<Auditor, AuditRecord> {

	@Autowired
	AuditorAuditRecordRepository repository;


	@Override
	public boolean authorise(Request<AuditRecord> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(Request<AuditRecord> request, AuditRecord entity, Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "item.title", "item.id","title", "auditor.firm", "creationMoment", "body", "status");
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
