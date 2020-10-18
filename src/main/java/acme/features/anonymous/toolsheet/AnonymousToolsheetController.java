
package acme.features.anonymous.toolsheet;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.toolsheets.Toolsheet;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Anonymous;

@Controller
@RequestMapping("anonymous/toolsheet")
public class AnonymousToolsheetController extends AbstractController<Anonymous, Toolsheet> {

	@Autowired
	private AnonymousToolsheetShowService	showService;

	@Autowired
	private AnonymousToolsheetListService	listService;


	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.LIST, listService);
		super.addBasicCommand(BasicCommand.SHOW, showService);
	}

}
