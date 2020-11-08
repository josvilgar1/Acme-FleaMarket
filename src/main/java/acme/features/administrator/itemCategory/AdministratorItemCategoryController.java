
package acme.features.administrator.itemCategory;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.configuration.ItemCategory;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Administrator;

@Controller
@RequestMapping("/administrator/item-category")
public class AdministratorItemCategoryController extends AbstractController<Administrator, ItemCategory> {

	@Autowired
	private AdministratorItemCategoryListService	listService;

	@Autowired
	private AdministratorItemCategoryShowService	showService;

	@Autowired
	private AdministratorItemCategoryUpdateService	updateService;


	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.LIST, listService);
		super.addBasicCommand(BasicCommand.SHOW, showService);
		super.addBasicCommand(BasicCommand.UPDATE, updateService);
	}

}
