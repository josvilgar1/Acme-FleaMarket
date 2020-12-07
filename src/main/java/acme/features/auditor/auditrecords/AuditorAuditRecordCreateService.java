
package acme.features.auditor.auditrecords;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.auditrecords.AuditRecord;
import acme.entities.configuration.SpamUtils;
import acme.entities.items.Item;
import acme.entities.roles.Auditor;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractCreateService;

@Service
public class AuditorAuditRecordCreateService implements AbstractCreateService<Auditor, AuditRecord> {

	@Autowired
	AuditorAuditRecordRepository	repository;

	@Autowired
	private SpamUtils				spamUtils;


	@Override
	public boolean authorise(final Request<AuditRecord> request) {
		assert request != null;

		return true;
	}

	@Override
	public void bind(final Request<AuditRecord> request, final AuditRecord entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
	}

	@Override
	public void unbind(final Request<AuditRecord> request, final AuditRecord entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "body", "status", "item.id", "item.title");
	}

	@Override
	public AuditRecord instantiate(final Request<AuditRecord> request) {
		AuditRecord result = new AuditRecord();
		int principalId;
		Integer itemId;
		Auditor auditor;
		Item item;

		principalId = request.getPrincipal().getAccountId();
		auditor = repository.findAuditorByUserAccount(principalId);

		itemId = request.getModel().getInteger("itemId");
		if (itemId == null)
			itemId = request.getModel().getInteger("item.id");
		item = repository.findItemById(itemId);

		result.setAuditor(auditor);
		result.setItem(item);
		return result;
	}

	@Override
	public void validate(final Request<AuditRecord> request, final AuditRecord entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		errors.state(request, !spamUtils.checkSpam(entity.getTitle()), "title", "acme.validation.spam",
			spamUtils.getThreshold(), spamUtils.getSpamWords());
		errors.state(request, !spamUtils.checkSpam(entity.getBody()), "body", "acme.validation.spam",
			spamUtils.getThreshold(), spamUtils.getSpamWords());
	}

	@Override
	public void create(final Request<AuditRecord> request, final AuditRecord entity) {
		assert request != null;
		assert entity != null;

		Date moment;
		moment = new Date(System.currentTimeMillis() - 1);
		entity.setCreationMoment(moment);
		repository.save(entity);

	}
}
