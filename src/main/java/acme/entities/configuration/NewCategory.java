
package acme.entities.configuration;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class NewCategory extends DomainEntity {

	private static final long	serialVersionUID	= 1L;

	@NotBlank
	private String				categories;

}
