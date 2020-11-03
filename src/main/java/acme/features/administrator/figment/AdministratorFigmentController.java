
package acme.features.administrator.figment;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.figments.Figment;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Administrator;

@Controller
@RequestMapping("/administrator/figment")
public class AdministratorFigmentController extends AbstractController<Administrator, Figment> {

	@Autowired
	private AdministratorFigmentListService		listService;

	@Autowired
	private AdministratorFigmentShowService		showService;

	@Autowired
	private AdministratorFigmentCreateService	createService;

	@Autowired
	private AdministratorFigmentDeleteService	deleteService;

	@Autowired
	private AdministratorFigmentUpdateService	updateService;


	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.LIST, listService);
		super.addBasicCommand(BasicCommand.SHOW, showService);
		super.addBasicCommand(BasicCommand.CREATE, createService);
		super.addBasicCommand(BasicCommand.DELETE, deleteService);
		super.addBasicCommand(BasicCommand.UPDATE, updateService);
	}
}
