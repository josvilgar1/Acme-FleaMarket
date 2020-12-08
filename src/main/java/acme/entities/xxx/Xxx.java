
package acme.entities.xxx;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import acme.entities.items.Item;
import acme.framework.datatypes.Money;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Xxx extends DomainEntity {

	private static final long	serialVersionUID	= 1L;

	@NotBlank
	private String				text;

	@Valid
	@NotNull
	private Money				priceMin;

	@Valid
	@NotNull
	private Money				priceMax;

	//	@Pattern(regexp = "^[A-Z]{3}-\\d{2}-\\d{1,6}$")
	@NotBlank
	private String				code;

	@OneToOne(optional = false)
	@Valid
	@NotNull
	private Item				item;
}
