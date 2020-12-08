
package acme.forms.dashboard;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Dashboard implements Serializable {

	private static final long	serialVersionUID	= 1L;

	//TODO: Cambiar
	Double						ratioItemWithXxx;
	Double						ratioRequestsWithLink;
	Double						ratioRequestsWithLinkAndPass;
}
