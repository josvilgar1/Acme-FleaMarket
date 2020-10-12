
package acme.features.anonymous.villegasbulletin;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.villegasbulletin.Villegasbulletin;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Anonymous;

@Controller
@RequestMapping("/anonymous/villegasbulletin/")
public class AnonymousVBulletinController extends AbstractController<Anonymous, Villegasbulletin> {

	@Autowired
	private AnonymousVBulletinListService	listService;

	@Autowired
	private AnonymousVBulletinCreateService	createService;


	@PostConstruct
	private void initialize() {
		super.addBasicCommand(BasicCommand.LIST, listService);
		super.addBasicCommand(BasicCommand.CREATE, createService);
	}
}
