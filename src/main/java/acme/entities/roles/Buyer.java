
package acme.entities.roles;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.CreditCardNumber;
import org.hibernate.validator.constraints.Range;

import acme.framework.entities.UserRole;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Buyer extends UserRole {

	// Serialisation identifier -----------------------------------------------

	private static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	@Email
	@NotBlank
	private String				email;

	@Pattern(regexp = "^(\\+\\d{1,3})?(\\(\\d{1,4}\\))?\\d{6,10}$")
	@Column(unique = true)
	@NotBlank
	private String				phone;

	@NotBlank
	private String				address;

	@NotBlank
	@CreditCardNumber
	private String				creditCardNumber;

	@NotBlank
	private String				creditCardName;

	@Range(min = 1, max = 12)
	@NotNull
	private Integer				creditCardMonth;

	@Min(value = 2020)
	@NotNull
	private Integer				creditCardYear;

	@Range(min = 1, max = 999)
	@NotNull
	private Integer				creditCardCVV;

	@NotBlank
	private String				creditCardType;

	// Derived attributes -----------------------------------------------------

	// Relationships ----------------------------------------------------------

}
