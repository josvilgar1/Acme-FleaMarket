
package acme.features.authenticated.material;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.materials.Material;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Authenticated;

@Controller
@RequestMapping("/authenticated/material/")
public class AuthenticatedMaterialController extends AbstractController<Authenticated, Material> {

	@Autowired
	AuthenticatedMaterialListService	listService;

	@Autowired
	AuthenticatedMaterialShowService	showService;


	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.LIST, listService);
		super.addBasicCommand(BasicCommand.SHOW, showService);
	}
}
