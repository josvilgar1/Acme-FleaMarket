
package acme.features.buyer.requests;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.items.Item;
import acme.entities.requests.Request;
import acme.entities.roles.Buyer;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface BuyerRequestRepository extends AbstractRepository {

	@Query("select r from Request r where r.id = ?1")
	Request findOneById(int id);

	@Query("select r from Request r where r.buyer.id = ?1")
	Collection<Request> findMyAll(int idBuyer);

	@Query("select b from Buyer b where b.id = ?1")
	Buyer findUserById(int userId);

	@Query("select i from Item i where i.id = ?1")
	Item findItemById(int itemId);

	@Query("select b from Buyer b where b.userAccount.id = ?1")
	Buyer findBuyerByUserAccount(int userAccountId);
	
	@Query("select r from Request r where r.ticker = ?1")
	Request findItemByTicker(String ticker);
}
