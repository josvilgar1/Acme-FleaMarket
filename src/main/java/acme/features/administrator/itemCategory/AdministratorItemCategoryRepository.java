
package acme.features.administrator.itemCategory;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.configuration.ItemCategory;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorItemCategoryRepository extends AbstractRepository {

	@Query("select ic from ItemCategory ic")
	Collection<ItemCategory> findMany();

}
