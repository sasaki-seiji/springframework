package example.app;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

public class AccountCreateForm implements Serializable {

	private static final long serialVersionUID = 1L;

	@Size(min = 1, message = "名前は必須です")
	private String name;
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

	@NotNull(message = "誕生日は必須です")
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date dateOfBirth;
	public Date getDateOfBirth() { return dateOfBirth; }
	public void setDateOfBirth(Date dateOfBirth) { this.dateOfBirth = dateOfBirth; }

	@NotEmpty(message = "住所は必須です")
	private String streetAddress;
	public String getStreetAddress() { return streetAddress; }
	public void setStreetAddress(String streetAddress) 
		{ this.streetAddress = streetAddress; }

}
