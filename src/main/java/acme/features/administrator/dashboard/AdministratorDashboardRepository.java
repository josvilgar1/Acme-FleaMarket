
package acme.features.administrator.dashboard;

import java.util.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorDashboardRepository extends AbstractRepository {

	// TODO: Cambiar

	@Query("select 1.0*count(r)/(select count(i) from Item i) from Xxx r")
	Double ratioItemsWithXxx();

	@Query("select 1.0*count(i)/(select count(i2) from Request i2 ) from Request i where i.xxxLink != null or i.xxxLink != ''")
	Double ratioRequestsWithLink();

	@Query("select 1.0*count(i)/(select count(i2) from Request i2) from Request i where i.password != null or i.password != ''")
	Double ratioRequestsWithLinkAndPass();

}
