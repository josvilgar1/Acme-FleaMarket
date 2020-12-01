/*
 * AuthenticatedSupplierCreateService.java
 *
 * Copyright (c) 2019 Rafael Corchuelo.
 *
 * In keeping with the traditional purpose of furthering education and research, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this software. It has been tested carefully, but it is not guaranteed for any particular
 * purposes. The copyright owner does not offer any warranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.features.authenticated.supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.roles.Supplier;
import acme.framework.components.Errors;
import acme.framework.components.HttpMethod;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.components.Response;
import acme.framework.entities.Authenticated;
import acme.framework.entities.Principal;
import acme.framework.entities.UserAccount;
import acme.framework.helpers.PrincipalHelper;
import acme.framework.services.AbstractCreateService;

@Service
public class AuthenticatedSupplierCreateService implements AbstractCreateService<Authenticated, Supplier> {

	@Autowired
	private AuthenticatedSupplierRepository repository;


	@Override
	public boolean authorise(final Request<Supplier> request) {
		assert request != null;

		return true;
	}

	@Override
	public void bind(final Request<Supplier> request, final Supplier entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
	}

	@Override
	public void unbind(final Request<Supplier> request, final Supplier entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "company", "homePage", "itemCategory", "description");
	}

	@Override
	public Supplier instantiate(final Request<Supplier> request) {
		assert request != null;

		Supplier result;
		Principal principal;
		int userAccountId;
		UserAccount userAccount;

		principal = request.getPrincipal();
		userAccountId = principal.getAccountId();
		userAccount = repository.findOneUserAccountById(userAccountId);

		result = new Supplier();
		result.setUserAccount(userAccount);

		return result;
	}

	@Override
	public void validate(final Request<Supplier> request, final Supplier entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
	}

	@Override
	public void create(final Request<Supplier> request, final Supplier entity) {
		assert request != null;
		assert entity != null;

		repository.save(entity);
	}

	@Override
	public void onSuccess(final Request<Supplier> request, final Response<Supplier> response) {
		assert request != null;
		assert response != null;

		if (request.isMethod(HttpMethod.POST))
			PrincipalHelper.handleUpdate();
	}

}
