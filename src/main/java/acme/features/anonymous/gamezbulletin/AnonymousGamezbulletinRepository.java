
package acme.features.anonymous.gamezbulletin;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.gamezbulletins.Gamezbulletin;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnonymousGamezbulletinRepository extends AbstractRepository {

	@Query("select g from Gamezbulletin g")
	Collection<Gamezbulletin> findMany();

}
