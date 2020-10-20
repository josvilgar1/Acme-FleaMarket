
package acme.features.anonymous.toolsheet;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.toolsheets.Toolsheet;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnonymousToolsheetRepository extends AbstractRepository {

	@Query("select t from Toolsheet t where t.id = ?1")
	Toolsheet findOneById(int id);

	@Query("select t from Toolsheet t")
	Collection<Toolsheet> findMany();
}
