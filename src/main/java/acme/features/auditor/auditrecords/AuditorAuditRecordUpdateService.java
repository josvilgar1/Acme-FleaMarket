
package acme.features.auditor.auditrecords;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.auditrecords.AuditRecord;
import acme.entities.configuration.SpamUtils;
import acme.entities.roles.Auditor;
import acme.enumeration.Status;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractUpdateService;

@Service
public class AuditorAuditRecordUpdateService implements AbstractUpdateService<Auditor, AuditRecord> {

	@Autowired
	AuditorAuditRecordRepository	repository;

	@Autowired
	private SpamUtils				spamUtils;


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

		request.unbind(entity, model, "title", "item.title", "item.id", "creationMoment", "body", "status");
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

		errors.state(request, !spamUtils.checkSpam(entity.getTitle()), "title", "acme.validation.spam",
			spamUtils.getThreshold(), spamUtils.getSpamWords());
		errors.state(request, !spamUtils.checkSpam(entity.getBody()), "body", "acme.validation.spam",
			spamUtils.getThreshold(), spamUtils.getSpamWords());

		if (errors.hasErrors())
			request.getModel().setAttribute("status", Status.DRAFT);
	}

	@Override
	public void update(Request<AuditRecord> request, AuditRecord entity) {
		repository.save(entity);
	}

}
