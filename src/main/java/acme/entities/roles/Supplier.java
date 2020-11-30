
package acme.entities.roles;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.URL;

import acme.framework.entities.UserRole;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Supplier extends UserRole {

	// Serialisation identifier -----------------------------------------------

	private static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	@NotBlank
	private String				company;

	@URL
	@NotBlank
	private String				homePage;

	@NotBlank
	private String				itemCategory;

	@NotBlank
	private String				description;

	// Derived attributes -----------------------------------------------------

	// Relationships ----------------------------------------------------------

}
