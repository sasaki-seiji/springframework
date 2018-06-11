package example.app;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

public class AccountCreateForm implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotEmpty
	private String username;
	public String getUsername() { return username; }
	public void setUsername(String name) { this.username = name; }
	
	@NotNull
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date dateOfBirth;
	public Date getDateOfBirth() { return dateOfBirth; }
	public void setDateOfBirth(Date date) { this.dateOfBirth = date; }
	
}
