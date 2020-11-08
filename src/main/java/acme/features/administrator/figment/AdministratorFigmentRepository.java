
package acme.features.administrator.figment;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.figments.Figment;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorFigmentRepository extends AbstractRepository {

	@Query("select f from Figment f where f.id = ?1")
	Figment findOneFigmentById(int id);

	@Query("select f from Figment f")
	Collection<Figment> findAllFigment();

}
