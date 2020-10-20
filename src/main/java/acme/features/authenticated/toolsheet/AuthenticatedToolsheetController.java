
package acme.features.authenticated.toolsheet;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.toolsheets.Toolsheet;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Authenticated;

@Controller
@RequestMapping("authenticated/toolsheet")
public class AuthenticatedToolsheetController extends AbstractController<Authenticated, Toolsheet> {

	@Autowired
	private AuthenticatedToolsheetShowService	showService;

	@Autowired
	private AuthenticatedToolsheetListService	listService;


	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.LIST, listService);
		super.addBasicCommand(BasicCommand.SHOW, showService);
	}

}
