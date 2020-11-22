
package acme.features.buyer.requests;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.requests.Request;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface BuyerRequestRepository extends AbstractRepository {

	@Query("select r from Request r where r.id = ?1")
	Request findOneById(int id);

	@Query("select r from Request r where r.id in (select ar.item.id from AuditRecord ar where ar.auditor.id = ?1)")
	Collection<Request> findRequestsHaveAuditRecord(int idBuyer);

	@Query("select r from Request r where r.id = ?1")
	Collection<Request> findMyAll(int idBuyer);

}
