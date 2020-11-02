
package acme.features.administrator.advertisement;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.advertisements.Advertisement;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Administrator;

@Controller
@RequestMapping("/administrator/advertisement")
public class AdministratorAdvertisementController extends AbstractController<Administrator, Advertisement> {

	@Autowired
	private AdministratorAdvertisementListService	listService;

	@Autowired
	private AdministratorAdvertisementShowService	showService;

	@Autowired
	private AdministratorAdvertisementCreateService	createService;

	@Autowired
	private AdministratorAdvertisementDeleteService	deleteService;

	@Autowired
	private AdministratorAdvertisementUpdateService	updateService;


	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.LIST, listService);
		super.addBasicCommand(BasicCommand.SHOW, showService);
		super.addBasicCommand(BasicCommand.CREATE, createService);
		super.addBasicCommand(BasicCommand.DELETE, deleteService);
		super.addBasicCommand(BasicCommand.UPDATE, updateService);
	}

}
