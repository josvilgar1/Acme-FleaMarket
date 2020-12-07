
package acme.features.auditor.auditrecords;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.auditrecords.AuditRecord;
import acme.entities.items.Item;
import acme.entities.roles.Auditor;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuditorAuditRecordRepository extends AbstractRepository {

	@Query("select ar from AuditRecord ar where ar.id = ?1")
	AuditRecord findOneById(int id);

	@Query("select ar from AuditRecord ar where ar.item.id = ?1")
	Collection<AuditRecord> findByItemId(int idItem);
	
	@Query("select i from Item i where i.id = ?1")
	Item findItemById(int itemId);
	
	@Query("select ar from AuditRecord ar where ar.auditor.id = ?1")
	Collection<AuditRecord> findByAuditorId(int auditorId);
	
	@Query("select a from Auditor a where a.userAccount.id = ?1")
	Auditor findAuditorByUserAccount(int userAccount);
}
