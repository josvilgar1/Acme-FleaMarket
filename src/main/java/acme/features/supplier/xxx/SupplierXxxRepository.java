
package acme.features.supplier.xxx;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.items.Item;
import acme.entities.xxx.Xxx;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface SupplierXxxRepository extends AbstractRepository {

	@Query("select x from Xxx x where x.id = ?1")
	Xxx findOneById(int id);

	@Query("select x from Xxx x")
	Collection<Xxx> findManyAll();

	@Query("select x from Xxx x where x.item.id = ?1")
	Xxx findOneByItemId(int itemId);

	@Query("select i from Item i where i.id = ?1")
	Item findItemById(int id);

}
