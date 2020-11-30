
package acme.features.auditor.items;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.components.CustomCommand;
import acme.entities.items.Item;
import acme.entities.roles.Auditor;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;

@Controller
@RequestMapping("/auditor/item/")
public class AuditorItemController extends AbstractController<Auditor, Item> {

	@Autowired
	AuditorItemListHaveService		listHaveService;

	@Autowired
	AuditorItemListNotHaveService	listNotHaveService;

	@Autowired
	AuditorItemShowService			showService;


	@PostConstruct
	private void initialise() {
		super.addCustomCommand(CustomCommand.LIST_HAVE, BasicCommand.LIST, listHaveService);
		super.addCustomCommand(CustomCommand.LIST_NOT_HAVE, BasicCommand.LIST, listNotHaveService);
		super.addBasicCommand(BasicCommand.SHOW, showService);
	}
}
