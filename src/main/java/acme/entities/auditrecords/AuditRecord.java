
package acme.entities.auditrecords;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import acme.entities.items.Item;
import acme.entities.roles.Auditor;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class AuditRecord extends DomainEntity {

	private static final long serialVersionUID = 1L;

	private enum Status {DRAFT, PUBLISHED}

	@NotBlank
	private String	title;

	@Temporal(TemporalType.TIMESTAMP)
	@Past
	private Date	creationMoment;

	@NotBlank
	private String	body;

	@Enumerated(EnumType.ORDINAL)
	@NotNull
	private Status	status;
	
	@ManyToOne(optional = false)
	@Valid
	@NotNull
	private Item				item;
	
	@ManyToOne(optional = false)
	@Valid
	@NotNull
	private Auditor				auditor;

}
