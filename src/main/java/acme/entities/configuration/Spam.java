
package acme.entities.configuration;

import javax.persistence.Entity;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Spam extends DomainEntity {

	private static final long	serialVersionUID	= 1L;

	@NotBlank
	private String				words;

	@Min(value = 0)
	@Max(value = 100)
	@NotNull
	private Double				threshold;

}
