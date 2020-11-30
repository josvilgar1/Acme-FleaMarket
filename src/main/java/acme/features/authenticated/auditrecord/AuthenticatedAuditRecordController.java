
package acme.features.authenticated.auditrecord;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.auditrecords.AuditRecord;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Authenticated;

@Controller
@RequestMapping("/authenticated/auditrecord/")
public class AuthenticatedAuditRecordController extends AbstractController<Authenticated, AuditRecord> {

	@Autowired
	AuthenticatedAuditRecordListService	listService;

	@Autowired
	AuthenticatedAuditRecordShowService	showService;


	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.LIST, listService);
		super.addBasicCommand(BasicCommand.SHOW, showService);
	}
}
