
package acme.entities.sections;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.URL;

import acme.entities.items.Item;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Section extends DomainEntity {

	private static final long	serialVersionUID	= 1L;

	// They must be unique within each specification sheet
	@Min(1)
	//	@NotNull
	// index is a MySQL reserved word, it is changed to index_
	@Column(name = "index_")
	private Integer				index;

	@NotBlank
	private String				title;

	@NotBlank
	private String				description;

	@URL
	private String				photo;

	@ManyToOne(optional = false)
	@Valid
	@NotNull
	private Item				item;

}
