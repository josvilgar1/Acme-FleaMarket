
package acme.features.supplier.xxx;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.roles.Supplier;
import acme.entities.xxx.Xxx;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;

@Controller
@RequestMapping("/supplier/xxx/")
public class SupplierXxxController extends AbstractController<Supplier, Xxx> {

	@Autowired
	SupplierXxxShowService		showService;

	@Autowired
	SupplierXxxCreateService	createService;

	@Autowired
	SupplierXxxUpdateService	updateService;

	@Autowired
	SupplierXxxDeleteService	deleteService;


	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.SHOW, showService);
		super.addBasicCommand(BasicCommand.CREATE, createService);
		super.addBasicCommand(BasicCommand.UPDATE, updateService);
		super.addBasicCommand(BasicCommand.DELETE, deleteService);
	}
}
