
package acme.features.administrator.dashboard;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.forms.dashboard.Dashboard;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractShowService;

@Service
public class AdministratorDashboardShowService implements AbstractShowService<Administrator, Dashboard> {

	@Autowired
	private AdministratorDashboardRepository repository;


	@Override
	public boolean authorise(final Request<Dashboard> request) {
		assert request != null;
		return true;
	}

	@Override
	public void unbind(final Request<Dashboard> request, final Dashboard entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		//TODO: Cambiar
		request.unbind(entity, model, "ratioItemWithXxx", "ratioRequestsWithLink", "ratioRequestsWithLinkAndPass");

	}

	@Override
	public Dashboard findOne(final Request<Dashboard> request) {
		assert request != null;

		Dashboard result = new Dashboard();

		//TODO: Cambiar
		result.setRatioItemWithXxx(this.repository.ratioItemsWithXxx());
		result.setRatioRequestsWithLink(this.repository.ratioRequestsWithLink());
		result.setRatioRequestsWithLinkAndPass(this.repository.ratioRequestsWithLinkAndPass());
		return result;
	}
}
