
package acme.features.authenticated.auditrecord;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.auditrecords.AuditRecord;
import acme.enumeration.Status;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedAuditRecordRepository extends AbstractRepository {

	@Query("select ar from AuditRecord ar where ar.id = ?1")
	AuditRecord findOneById(int id);

	@Query("select ar from AuditRecord ar where ar.item.id = ?1 and ar.status = ?2")
	Collection<AuditRecord> findPublishedByItemId(int idItem, Status status);
}
