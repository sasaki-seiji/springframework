package example.convert.converter_xml;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

public class EmailValue {

	@Size(max = 256)
	@Email
	private String value;
	
	public void setValue(String value) { this.value = value; }
	public String getValue() { return value; }
	public String toString() { return getValue(); }
}
