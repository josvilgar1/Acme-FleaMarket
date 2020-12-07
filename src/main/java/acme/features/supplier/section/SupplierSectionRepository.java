
package acme.features.supplier.section;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.items.Item;
import acme.entities.requests.Request;
import acme.entities.sections.Section;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface SupplierSectionRepository extends AbstractRepository {

	@Query("select s from Section s where s.id = ?1")
	Section findOneById(int id);

	@Query("select s.item from Section s where s.id = ?1")
	Item findItemBySectionId(int itemId);

	@Query("select i from Item i where i.id = ?1")
	Item findItemById(int id);

	@Query("select s from Section s")
	Collection<Section> findManyAll();

	@Query("select s from Section s where s.item.id = ?1")
	Collection<Section> findManyByItemId(int itemId);

	@Query("select r from Request r where r.item.id = ?1")
	Collection<Request> findAllRequestByItemId(int itemId);

}
