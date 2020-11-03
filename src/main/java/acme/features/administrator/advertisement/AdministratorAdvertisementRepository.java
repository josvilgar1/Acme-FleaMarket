
package acme.features.administrator.advertisement;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.advertisements.Advertisement;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorAdvertisementRepository extends AbstractRepository {

	@Query("select m from Advertisement m where m.id = ?1")
	Advertisement findOneAdvertisementById(int id);

	@Query("select m from Advertisement m")
	Collection<Advertisement> findAllAdvertisement();

}
