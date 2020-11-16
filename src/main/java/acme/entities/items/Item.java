
package acme.entities.items;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.URL;

import acme.entities.roles.Supplier;
import acme.framework.datatypes.Money;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Item extends DomainEntity {

	private static final long	serialVersionUID	= 1L;

	@Pattern(regexp = "^[A-Z]{3}-\\d{2}-\\d{6}$")
	@Column(unique = true)
	@NotBlank
	private String				ticker;

	@Temporal(TemporalType.TIMESTAMP)
	@Past
	private Date				creationMoment;

	@NotBlank
	private String				title;

	@NotBlank
	private String				itemCategory;

	@NotBlank
	private String				description;

	@Valid
	@NotNull
	private Money				price;

	@URL
	private String				photo;

	@URL
	private String				link;

	@ManyToOne(optional = false)
	@Valid
	@NotNull
	private Supplier			supplier;

}
