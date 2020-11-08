
package acme.features.administrator.suggestion;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.suggestions.Suggestion;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Administrator;

@Controller
@RequestMapping("administrator/suggestion")
public class AdministratorSuggestionController extends AbstractController<Administrator, Suggestion> {

	@Autowired
	private AdministratorSuggestionShowService		showService;

	@Autowired
	private AdministratorSuggestionListService		listService;

	@Autowired
	private AdministratorSuggestionCreateService	createService;

	@Autowired
	private AdministratorSuggestionUpdateService	updateService;

	@Autowired
	private AdministratorSuggestionDeleteService	deleteService;


	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.LIST, listService);
		super.addBasicCommand(BasicCommand.SHOW, showService);
		super.addBasicCommand(BasicCommand.CREATE, createService);
		super.addBasicCommand(BasicCommand.UPDATE, updateService);
		super.addBasicCommand(BasicCommand.DELETE, deleteService);
	}

}
