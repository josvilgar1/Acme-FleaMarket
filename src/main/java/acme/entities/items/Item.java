
package acme.entities.items;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import javax.persistence.Column;
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

	private static final long serialVersionUID = 1L;

	public enum Status { DRAFT, PUBLISHED }

	@Pattern(regexp = "^[A-Z]{3}-\\d{2}-\\d{6}$")
	@Column(unique = true)
	private String		ticker;

	@Temporal(TemporalType.TIMESTAMP)
	@Past
	private Date		creationMoment;

	@NotBlank
	private String		title;

	@NotBlank
	private String		itemCategory;

	@NotBlank
	private String		description;

	@Valid
	@NotNull
	private Money		price;

	@URL
	private String		photo;

	@URL
	private String		link;

	@Enumerated(EnumType.ORDINAL)
	@NotNull
	private Status		status;

	@ManyToOne(optional = false)
	@Valid
	@NotNull
	private Supplier	supplier;


	public void generateTicker() {
		StringBuilder sb = new StringBuilder();
		// Añadimos la categoria
		if (itemCategory.length() >= 3)
			sb.append(itemCategory.substring(0, 3).toUpperCase());
		else if (itemCategory.length() == 2)
			sb.append(itemCategory.substring(0, 2).toUpperCase()).append("X");
		else
			sb.append(itemCategory.substring(0, 1).toUpperCase()).append("XX");
		sb.append("-");
		// Añadimos los dos últimos digitos del año
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(creationMoment);
		sb.append(String.valueOf(calendar.get(Calendar.YEAR)).substring(2, 4));
		sb.append("-");
		// Añadimos un secuencial
		Random r = new Random();
		int seq = r.nextInt(1000000);
		sb.append(seq);
		// Asignamos el valor obtenido al ticker
		ticker = sb.toString();
	}

}
