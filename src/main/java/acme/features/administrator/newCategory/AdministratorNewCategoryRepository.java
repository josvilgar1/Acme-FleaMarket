
package acme.features.administrator.newCategory;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.configuration.NewCategory;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorNewCategoryRepository extends AbstractRepository {

	@Query("select nc from NewCategory nc")
	Collection<NewCategory> findMany();

	@Query("select nc from NewCategory nc where nc.id = ?1")
	NewCategory findOneNewCategoryById(int id);

}
