
package acme.features.auditor.auditrecords;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.auditrecords.AuditRecord;
import acme.entities.roles.Auditor;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractUpdateService;

@Service
public class AuditorAuditRecordUpdateService implements AbstractUpdateService<Auditor, AuditRecord> {

	@Autowired
	AuditorAuditRecordRepository repository;


	@Override
	public boolean authorise(Request<AuditRecord> request) {
		assert request != null;
		return true;
	}

	@Override
	public void bind(Request<AuditRecord> request, AuditRecord entity, Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
	}

	@Override
	public void unbind(Request<AuditRecord> request, AuditRecord entity, Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "item.title","item.id", "creationMoment", "body", "status");
	}

	@Override
	public AuditRecord findOne(Request<AuditRecord> request) {
		assert request != null;

		AuditRecord auditRecord = new AuditRecord();
		int id = request.getModel().getInteger("id");
		auditRecord = repository.findOneById(id);

		return auditRecord;
	}

	@Override
	public void validate(Request<AuditRecord> request, AuditRecord entity, Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		
	}

	@Override
	public void update(Request<AuditRecord> request, AuditRecord entity) {
		repository.save(entity);
	}

}
