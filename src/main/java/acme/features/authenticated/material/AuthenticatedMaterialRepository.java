
package acme.features.authenticated.material;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.materials.Material;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedMaterialRepository extends AbstractRepository {

	@Query("select m from Material m where m.id = ?1")
	Material findOneById(int id);

	@Query("select m from Material m")
	Collection<Material> findManyAll();
}
