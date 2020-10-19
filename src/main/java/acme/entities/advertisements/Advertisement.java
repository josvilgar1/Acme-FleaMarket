
package acme.entities.advertisements;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.URL;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Advertisement extends DomainEntity {

	private static final long	serialVersionUID	= 1L;

	@NotBlank
	private String				title;

	@URL
	@NotBlank
	private String				picture;

	@Temporal(TemporalType.TIMESTAMP)
	private Date				moment;

	//TODO: finalDate MUST be after inicialDate
	@NotNull
	@Future
	private Date				inicialDate;

	@NotNull
	@Future
	private Date				finalDate;

	@NotBlank
	private String				text;

	@NotBlank
	private String				volumeDiscounts;
}
