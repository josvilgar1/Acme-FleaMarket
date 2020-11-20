
package acme.features.auditor.items;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.items.Item;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuditorItemRepository extends AbstractRepository {

	@Query("select i from Item i where i.id = ?1")
	Item findOneById(int id);

	@Query("select i from Item i where i.id in (select ar.item.id from AuditRecord ar where ar.auditor.id = ?1)")
	Collection<Item> findItemsHaveAuditRecord(int idAuditor);

	@Query("select i from Item i where i.id in (select ar.item.id from AuditRecord ar where ar.auditor.id != ?1)")
	Collection<Item> findItemsNotHaveAuditRecord(int idAuditor);
}
