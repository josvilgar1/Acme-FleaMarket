
package acme.features.supplier.items;

import java.util.Collection;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.items.Item;
import acme.entities.requests.Request;
import acme.entities.sections.Section;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface SupplierItemRepository extends AbstractRepository {

	@Query("select i from Item i where i.id = ?1")
	Item findOneById(int id);

	@Query("select i from Item i where i.supplier.id = ?1")
	Collection<Item> findMyAll(int idSupplier);

	@Query("select i from Item i where i.ticker = ?1")
	Collection<Item> findAllByTicker(String ticker);

	@Query("select s from Section s where s.item.id = ?1")
	Collection<Section> findAllSectionByItemId(int itemId);

	@Query("select r from Request r where r.item.id = ?1")
	Collection<Request> findAllRequestByItemId(int itemId);

	@Modifying
	@Query("delete from Section s where s.item.id = ?1")
	void deleteSectionsByItem(int itemId);

	@Modifying
	@Query("delete from AuditRecord ar where ar.item.id = ?1")
	void deleteAuditrecordByItem(int itemId);

	@Modifying
	@Query("delete from Message m where m.forum.id = (select f from Forum f where f.item.id = ?1)")
	void deleteMessagesByItem(int itemId);

	@Modifying
	@Query("delete from Forum f where f.item.id = ?1")
	void deleteForumByItem(int itemId);
}
