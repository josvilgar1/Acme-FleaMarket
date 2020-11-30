
package acme.features.authenticated.section;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.sections.Section;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedSectionRepository extends AbstractRepository {

	@Query("select s from Section s where s.id = ?1")
	Section findOneById(int id);

	@Query("select s from Section s")
	Collection<Section> findManyAll();

	@Query("select s from Section s where s.item.id = ?1")
	Collection<Section> findManyByItemId(int itemId);

}
