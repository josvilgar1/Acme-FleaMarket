
package acme.features.administrator.news;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.news.New;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorNewRepository extends AbstractRepository {

	@Query("select n from New n where n.id = ?1")
	New findOneById(int id);

	@Query("select n from New n")
	Collection<New> findMany();
}
