
package acme.features.anonymous.villegasbulletin;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.villegasbulletin.Villegasbulletin;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnonymousVBulletinRepository extends AbstractRepository {

	@Query("select s from Villegasbulletin s")
	Collection<Villegasbulletin> findMany();

}
