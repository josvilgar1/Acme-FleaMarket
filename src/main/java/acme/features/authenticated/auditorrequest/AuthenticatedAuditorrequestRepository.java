
package acme.features.authenticated.auditorrequest;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.auditorrequests.Auditorrequest;
import acme.framework.entities.Authenticated;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedAuditorrequestRepository extends AbstractRepository {

	@Query("select a from Auditorrequest a where a.id = ?1")
	Auditorrequest findOneById(int id);

	@Query("select a from Authenticated a where a.id = ?1")
	Authenticated findAuthenticatedById(int id);

	@Query("select a from Auditorrequest a where a.authenticated.userAccount.id = ?1")
	Auditorrequest findOneByUserAccountId(int id);
}
