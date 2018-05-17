package example.app;

import java.io.Serializable;
import org.hibernate.validator.constraints.NotEmpty;

public class ValidationForm implements Serializable {

	private static final long serialVersionUID = 1L;

	@AlphaNumeric
	private String alphaNumeric;
	public String getAlphaNumeric() { return alphaNumeric; }
	public void setAlphaNumeric(String v) { this.alphaNumeric = v; }
	
	@NotEmpty
	@AlphaNumeric
	private String notEmptyAlphaNumeric;
	public String getNotEmptyAlphaNumeric() { return notEmptyAlphaNumeric; }
	public void setNotEmptyAlphaNumeric(String v) { this.notEmptyAlphaNumeric = v; }
}
