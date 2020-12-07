
package acme.entities.requests;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import acme.entities.items.Item;
import acme.entities.roles.Buyer;
import acme.enumeration.Process;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Request extends DomainEntity {

	private static final long	serialVersionUID	= 1L;

	@Pattern(regexp = "^[A-Z]{3}-\\d{2}-\\d{6}$")
	@Column(unique = true)
	@NotBlank
	private String				ticker;

	@Temporal(TemporalType.TIMESTAMP)
	@Past
	private Date				creationMoment;

	@Min(1)
	@NotNull
	private Integer				quantity;

	private String				notes;

	@ManyToOne(optional = false)
	@Valid
	@NotNull
	private Buyer				buyer;

	@Enumerated(EnumType.ORDINAL)
	@NotNull
	private Process				process;

	private String				justification;

	@ManyToOne(optional = false)
	@Valid
	@NotNull
	private Item				item;

}
