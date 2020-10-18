
package acme.entities.toolsheets;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Range;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Toolsheet extends DomainEntity {

	private static final long	serialVersionUID	= 1L;

	@NotBlank
	private String				title;

	@NotBlank
	private String				description;

	@NotBlank
	private String				providerName;

	@NotBlank
	private String				homePage;

	@Range(min = 0, max = 5)
	private Integer				stars;
}
