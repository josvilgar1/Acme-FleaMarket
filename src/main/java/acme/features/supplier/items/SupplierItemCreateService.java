
package acme.features.supplier.items;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.configuration.SpamUtils;
import acme.entities.forums.Forum;
import acme.entities.items.Item;
import acme.entities.roles.Supplier;
import acme.enumeration.Status;
import acme.features.authenticated.forum.AuthenticatedForumRepository;
import acme.features.authenticated.supplier.AuthenticatedSupplierRepository;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractCreateService;

@Service
public class SupplierItemCreateService implements AbstractCreateService<Supplier, Item> {

	@Autowired
	SupplierItemRepository			repository;

	@Autowired
	AuthenticatedSupplierRepository	supplierRepository;

	@Autowired
	AuthenticatedForumRepository	forumRepository;

	@Autowired
	private SpamUtils				spamUtils;


	@Override
	public boolean authorise(final Request<Item> request) {
		assert request != null;
		return true;
	}

	@Override
	public void bind(final Request<Item> request, final Item entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
	}

	@Override
	public void unbind(final Request<Item> request, final Item entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "itemCategory", "description", "price", "photo", "link");
	}

	@Override
	public Item instantiate(final Request<Item> request) {
		Item result = new Item();
		result.setStatus(Status.DRAFT);
		int principalId = request.getPrincipal().getAccountId();
		Supplier supplier = supplierRepository.findOneSupplierByUserAccountId(principalId);
		result.setSupplier(supplier);
		return result;
	}

	@Override
	public void validate(final Request<Item> request, final Item entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		errors.state(request, !spamUtils.checkSpam(entity.getTitle()), "title", "acme.validation.spam",
			spamUtils.getThreshold(), spamUtils.getSpamWords());
		errors.state(request, !spamUtils.checkSpam(entity.getDescription()), "description", "acme.validation.spam",
			spamUtils.getThreshold(), spamUtils.getSpamWords());
	}

	@Override
	public void create(final Request<Item> request, final Item entity) {
		assert request != null;
		assert entity != null;

		Date moment;
		moment = new Date(System.currentTimeMillis() - 1);
		entity.setCreationMoment(moment);
		boolean existsTicker;
		synchronized (this) {
			do {
				entity.generateTicker();
				if (!repository.findAllByTicker(entity.getTicker()).isEmpty())
					existsTicker = true;
				else
					existsTicker = false;
			} while (existsTicker);
			repository.save(entity);
		}
		Forum forum = new Forum();
		forum.setItem(entity);
		forumRepository.save(forum);
	}
}
