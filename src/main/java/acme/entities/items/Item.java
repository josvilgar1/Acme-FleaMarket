
package acme.entities.items;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Index;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.URL;

import acme.entities.roles.Supplier;
import acme.enumeration.Status;
import acme.framework.datatypes.Money;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(indexes = {
	@Index(columnList = "ticker"), @Index(columnList = "status")
})
public class Item extends DomainEntity {

	private static final long	serialVersionUID	= 1L;

	@Pattern(regexp = "^[A-Z]{3}-\\d{2}-\\d{1,6}$")
	@Column(unique = true)
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

	@Enumerated(EnumType.ORDINAL)
	@NotNull
	private Status				status;

	@ManyToOne(optional = false)
	@Valid
	@NotNull
	private Supplier			supplier;

	@Transient
	private boolean				isNew;


	public boolean getIsNew() {
		Calendar creationMoment = Calendar.getInstance();
		creationMoment.setTime(this.creationMoment);
		Calendar instance = Calendar.getInstance();
		instance.add(Calendar.DAY_OF_YEAR, -7);
		isNew = instance.before(creationMoment) || instance.equals(creationMoment);
		return isNew;
	}

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
