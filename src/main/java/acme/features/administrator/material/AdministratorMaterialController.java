
package acme.features.administrator.material;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.materials.Material;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Administrator;

@Controller
@RequestMapping("/administrator/material")
public class AdministratorMaterialController extends AbstractController<Administrator, Material> {

	@Autowired
	private AdministratorMaterialListService	listService;

	@Autowired
	private AdministratorMaterialShowService	showService;

	@Autowired
	private AdministratorMaterialCreateService	createService;

	@Autowired
	private AdministratorMaterialDeleteService	deleteService;

	@Autowired
	private AdministratorMaterialUpdateService	updateService;


	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.LIST, listService);
		super.addBasicCommand(BasicCommand.SHOW, showService);
		super.addBasicCommand(BasicCommand.CREATE, createService);
		super.addBasicCommand(BasicCommand.DELETE, deleteService);
		super.addBasicCommand(BasicCommand.UPDATE, updateService);
	}

}
