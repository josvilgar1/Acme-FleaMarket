
package acme.entities.news;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.URL;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class New extends DomainEntity {

	private static final long	serialVersionUID	= 1L;

	@NotBlank
	private String				category;

	@NotBlank
	@URL
	private String				headerPicture;

	@NotBlank
	private String				title;

	@Temporal(TemporalType.TIMESTAMP)
	@Past
	private Date				creationMoment;

	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	private Date				deadlineMoment;

	@NotBlank
	private String				body;

	private String				links;
}
