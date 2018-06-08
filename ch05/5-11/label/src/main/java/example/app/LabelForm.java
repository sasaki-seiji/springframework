package example.app;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotEmpty;

public class LabelForm implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotEmpty
	private String opinionsAndRequests;
	public String getOpinionsAndRequests() { return opinionsAndRequests; }
	public void setOpinionsAndRequests(String value) { this.opinionsAndRequests = value; }
}
