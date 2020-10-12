
package acme.entities.villegasbulletin;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Range;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Villegasbulletin extends DomainEntity {

	private static final long	serialVersionUID	= 1L;

	@NotBlank
	private String				author;

	@Temporal(TemporalType.TIMESTAMP)
	@Past
	private Date				date;

	@NotBlank
	private String				title;

	@NotNull
	@Range(min = -90, max = 90)
	private Double				latitude;

	@NotNull
	@Range(min = -180, max = 180)
	private Double				longitude;

}
