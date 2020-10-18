
package acme.features.administrator.newCategory;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.configuration.NewCategory;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Administrator;

@Controller
@RequestMapping("/administrator/new-category")
public class AdministratorNewCategoryController extends AbstractController<Administrator, NewCategory> {

	@Autowired
	private AdministratorNewCategoryListService listService;


	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.LIST, listService);
	}

}
