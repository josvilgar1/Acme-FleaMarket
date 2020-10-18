
package acme.features.anonymous.news;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.news.New;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnonymousNewRepository extends AbstractRepository {

	@Query("select n from New n where n.id = ?1")
	New findOneById(int id);

	@Query("select n from New n where n.deadlineMoment > current_timestamp()")
	Collection<New> findActive();
}
