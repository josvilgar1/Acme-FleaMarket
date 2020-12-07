
package acme.features.auditor.auditrecords;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.auditrecords.AuditRecord;
import acme.entities.roles.Auditor;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;

@Controller
@RequestMapping("/auditor/auditrecord/")
public class AuditorAuditRecordController extends AbstractController<Auditor, AuditRecord> {

	@Autowired
	AuditorAuditRecordListMineService	listService;

	@Autowired
	AuditorAuditRecordShowService	showService;

	@Autowired
	AuditorAuditRecordCreateService	createService;
	
	@Autowired
	AuditorAuditRecordUpdateService	updateService;

	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.LIST, listService);
		super.addBasicCommand(BasicCommand.SHOW, showService);
		super.addBasicCommand(BasicCommand.CREATE, createService);
		super.addBasicCommand(BasicCommand.UPDATE, updateService);
	}
}
