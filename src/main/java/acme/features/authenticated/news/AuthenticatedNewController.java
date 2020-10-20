
package acme.features.authenticated.news;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.components.CustomCommand;
import acme.entities.news.New;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Authenticated;

@Controller
@RequestMapping("authenticated/new")
public class AuthenticatedNewController extends AbstractController<Authenticated, New> {

	@Autowired
	private AuthenticatedNewShowService			showService;

	@Autowired
	private AuthenticatedNewListActiveService	listActiveService;


	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.SHOW, showService);

		//CustomCommand
		super.addCustomCommand(CustomCommand.LIST_ACTIVE, BasicCommand.LIST, listActiveService);
	}

}
