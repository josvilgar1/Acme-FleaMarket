
package acme.features.supplier.request;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.requests.Request;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface SupplierRequestRepository extends AbstractRepository {

	@Query("select r from Request r where r.id = ?1")
	Request findOneById(int id);

	@Query("select r from Request r where r.item.supplier.id = ?1")
	Collection<Request> findMyAll(int idSupplier);

	@Query("select r from Request r where r.item.supplier.id = ?1 order by r.creationMoment desc, r.ticker asc")
	Collection<Request> findMyAllOrder(int idSupplier);

}
