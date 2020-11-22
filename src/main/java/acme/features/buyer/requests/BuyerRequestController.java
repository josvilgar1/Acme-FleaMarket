
package acme.features.buyer.requests;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.requests.Request;
import acme.entities.roles.Buyer;
import acme.framework.controllers.AbstractController;

@Controller
@RequestMapping("/buyer/request/")
public class BuyerRequestController extends AbstractController<Buyer, Request> {

	@Autowired
	BuyerRequestListService	listService;

	@Autowired
	BuyerRequestShowService	showService;


	@Autowired
	//	BuyerRequestCreateService	createService;

	@PostConstruct
	private void initialise() {
		//		super.addBasicCommand(BasicCommand.LIST, listService);
		//		super.addBasicCommand(BasicCommand.SHOW, showService);
		//	super.addBasicCommand(BasicCommand.CREATE, createService);
	}
}
