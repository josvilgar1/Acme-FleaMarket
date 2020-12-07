
package acme.entities.requests;

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
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import acme.entities.items.Item;
import acme.entities.roles.Buyer;
import acme.enumeration.Process;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(indexes = {
	@Index(columnList = "ticker")
})
public class Request extends DomainEntity {

	private static final long	serialVersionUID	= 1L;

	@Pattern(regexp = "^[A-Z]{3}-\\d{2}-\\d{1,6}$")
	@Column(unique = true)
	private String				ticker;

	@Temporal(TemporalType.TIMESTAMP)
	@Past
	private Date				creationMoment;

	@Min(1)
	@NotNull
	private Integer				quantity;

	private String				notes;

	@Enumerated(EnumType.ORDINAL)
	@NotNull
	private Process				process;

	private String				justification;

	@ManyToOne(optional = false)
	@Valid
	@NotNull
	private Buyer				buyer;

	@ManyToOne(optional = false)
	@Valid
	@NotNull
	private Item				item;


	public String generateTicker() {
		StringBuilder sb = new StringBuilder();
		// Add category
		if (item.getItemCategory().length() >= 3)
			sb.append(item.getItemCategory().substring(0, 3).toUpperCase());
		else if (item.getItemCategory().length() == 2)
			sb.append(item.getItemCategory().substring(0, 2).toUpperCase()).append("X");
		else
			sb.append(item.getItemCategory().substring(0, 1).toUpperCase()).append("XX");
		sb.append("-");
		// Add last 2 year's digits
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(creationMoment);
		sb.append(String.valueOf(calendar.get(Calendar.YEAR)).substring(2, 4));
		sb.append("-");
		// Add secuential
		Random r = new Random();
		int seq = r.nextInt(1000000);
		sb.append(seq);
		// Assign value obtained to ticker
		return sb.toString();
	}
}
