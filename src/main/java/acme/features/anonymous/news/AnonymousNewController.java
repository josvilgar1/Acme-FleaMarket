
package acme.features.anonymous.news;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.components.CustomCommand;
import acme.entities.news.New;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Anonymous;

@Controller
@RequestMapping("anonymous/new")
public class AnonymousNewController extends AbstractController<Anonymous, New> {

	@Autowired
	private AnonymousNewShowService			showService;

	@Autowired
	private AnonymousNewListActiveService	listActiveService;


	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.SHOW, showService);

		//CustomCommand
		super.addCustomCommand(CustomCommand.LIST_ACTIVE, BasicCommand.LIST, listActiveService);
	}

}
