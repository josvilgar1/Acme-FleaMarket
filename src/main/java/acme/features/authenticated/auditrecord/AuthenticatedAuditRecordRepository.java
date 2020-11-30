
package acme.features.authenticated.auditrecord;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.auditrecords.AuditRecord;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedAuditRecordRepository extends AbstractRepository {

	@Query("select ar from AuditRecord ar where ar.id = ?1")
	AuditRecord findOneById(int id);

	@Query("select ar from AuditRecord ar where ar.item.id = ?1")
	Collection<AuditRecord> findByItemId(int idItem);
}
