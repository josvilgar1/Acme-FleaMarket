
package acme.features.administrator.news;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.news.New;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Administrator;

@Controller
@RequestMapping("administrator/new")
public class AdministratorNewController extends AbstractController<Administrator, New> {

	@Autowired
	private AdministratorNewShowService		showService;

	@Autowired
	private AdministratorNewListService		listActiveService;

	@Autowired
	private AdministratorNewCreateService	createService;


	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.SHOW, showService);
		super.addBasicCommand(BasicCommand.LIST, listActiveService);
		super.addBasicCommand(BasicCommand.CREATE, createService);
	}

}
