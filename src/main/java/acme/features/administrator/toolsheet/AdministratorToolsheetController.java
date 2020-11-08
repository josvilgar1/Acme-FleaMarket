
package acme.features.administrator.toolsheet;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.toolsheets.Toolsheet;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Administrator;

@Controller
@RequestMapping("administrator/toolsheet")
public class AdministratorToolsheetController extends AbstractController<Administrator, Toolsheet> {

	@Autowired
	private AdministratorToolsheetShowService	showService;

	@Autowired
	private AdministratorToolsheetListService	listService;

	@Autowired
	private AdministratorToolsheetCreateService	createService;

	@Autowired
	private AdministratorToolsheetUpdateService	updateService;

	@Autowired
	private AdministratorToolsheetDeleteService	deleteService;


	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.LIST, listService);
		super.addBasicCommand(BasicCommand.SHOW, showService);
		super.addBasicCommand(BasicCommand.CREATE, createService);
		super.addBasicCommand(BasicCommand.UPDATE, updateService);
		super.addBasicCommand(BasicCommand.DELETE, deleteService);
	}

}
