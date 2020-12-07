
package acme.features.supplier.request;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.requests.Request;
import acme.entities.roles.Supplier;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;

@Controller
@RequestMapping("/supplier/request/")
public class SupplierRequestController extends AbstractController<Supplier, Request> {

	@Autowired
	SupplierRequestListService		listService;

	@Autowired
	SupplierRequestShowService		showService;

	@Autowired
	SupplierRequestUpdateService	updateService;


	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.LIST, listService);
		super.addBasicCommand(BasicCommand.SHOW, showService);
		super.addBasicCommand(BasicCommand.UPDATE, updateService);
	}
}
