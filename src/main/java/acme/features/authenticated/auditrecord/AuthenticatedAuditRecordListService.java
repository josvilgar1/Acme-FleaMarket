
package acme.features.authenticated.auditrecord;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.auditrecords.AuditRecord;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractListService;

@Service
public class AuthenticatedAuditRecordListService implements AbstractListService<Authenticated, AuditRecord> {

	@Autowired
	AuthenticatedAuditRecordRepository repository;


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

		request.unbind(entity, model, "item.title", "title", "auditor.firm");
	}

	@Override
	public Collection<AuditRecord> findMany(Request<AuditRecord> request) {
		assert request != null;

		Collection<AuditRecord> result;
		int id = request.getModel().getInteger("id");
		result = repository.findByItemId(id);

		return result;
	}

}
