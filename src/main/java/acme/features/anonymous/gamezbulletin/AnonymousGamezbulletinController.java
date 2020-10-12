
package acme.features.anonymous.gamezbulletin;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.gamezbulletins.Gamezbulletin;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Anonymous;

@Controller
@RequestMapping("/anonymous/gamezbulletin/")
public class AnonymousGamezbulletinController extends AbstractController<Anonymous, Gamezbulletin> {

	@Autowired
	private AnonymousGamezbulletinListService	listService;

	@Autowired
	private AnonymousGamezbulletinCreateService	createService;


	@PostConstruct
	private void initialize() {
		super.addBasicCommand(BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.CREATE, this.createService);
	}

}
