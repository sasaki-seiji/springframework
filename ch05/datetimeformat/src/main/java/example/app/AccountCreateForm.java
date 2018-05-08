package example.app;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class AccountCreateForm implements Serializable {

	private static final long serialVersionUID = 1L;

	@DateTimeFormat(pattern = "yyyyMMdd")
	private Date dateOfBirth;
	
	public Date getDateOfBirth() { return this.dateOfBirth; }
	public void setDateOfBirth(Date date) { this.dateOfBirth = date; }
}
