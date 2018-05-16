package example.app;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class ValidationForm implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotNull
	private String notNullString;
	public String getNotNullString() { return notNullString; }
	public void setNotNullString(String v) { this.notNullString = v; }
	
	@Size(min = 4)
	private String min4String;
	public String getMin4String() { return min4String; }
	public void setMin4String(String v) { this.min4String = v; }
	
	@NotNull
	@Size(min = 4)
	private String notNullMin4String;
	public String getNotNullMin4String() { return notNullMin4String; }
	public void setNotNullMin4String(String v) { this.notNullMin4String = v; }
}
