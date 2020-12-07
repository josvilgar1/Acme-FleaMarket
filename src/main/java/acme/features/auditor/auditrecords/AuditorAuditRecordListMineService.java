
package acme.features.auditor.auditrecords;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.auditrecords.AuditRecord;
import acme.entities.roles.Auditor;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractListService;

@Service
public class AuditorAuditRecordListMineService implements AbstractListService<Auditor, AuditRecord> {

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

		request.unbind(entity, model, "title", "item.title", "auditor.firm");
	}

	@Override
	public Collection<AuditRecord> findMany(Request<AuditRecord> request) {
		assert request != null;

		Collection<AuditRecord> result;
		
		int auditorId = request.getPrincipal().getActiveRoleId();
		result = repository.findByAuditorId(auditorId);

		return result;
	}

}
