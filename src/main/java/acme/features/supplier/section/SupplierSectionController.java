
package acme.features.supplier.section;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.roles.Supplier;
import acme.entities.sections.Section;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;

@Controller
@RequestMapping("/supplier/section/")
public class SupplierSectionController extends AbstractController<Supplier, Section> {

	@Autowired
	SupplierSectionListService		listService;

	@Autowired
	SupplierSectionShowService		showService;

	@Autowired
	SupplierSectionCreateService	createService;

	@Autowired
	SupplierSectionUpdateService	updateService;

	@Autowired
	SupplierSectionDeleteService	deleteService;


	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.LIST, listService);
		super.addBasicCommand(BasicCommand.SHOW, showService);
		super.addBasicCommand(BasicCommand.CREATE, createService);
		super.addBasicCommand(BasicCommand.UPDATE, updateService);
		super.addBasicCommand(BasicCommand.DELETE, deleteService);
	}
}
