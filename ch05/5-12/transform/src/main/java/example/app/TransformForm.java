package example.app;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class TransformForm implements Serializable {

	private static final long serialVersionUID = 1L;

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) // yyyy-MM-dd
	private Date departureDate;
	public Date getDepartureDate() { return departureDate; }
	public void setDepartureDate(Date date) { this.departureDate = date; }
}
