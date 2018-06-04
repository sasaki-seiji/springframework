package example.app;

import java.io.Serializable;

public class CheckboxesForm implements Serializable {

	private static final long serialVersionUID = 1L;

	private String[] hobbies = new String[] {};
	public String[] getHobbies() { return hobbies; }
	public void setHobbies(String[] v) { hobbies = v; }
}
