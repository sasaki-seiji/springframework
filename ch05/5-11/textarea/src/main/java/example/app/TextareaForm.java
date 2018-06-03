package example.app;

import java.io.Serializable;

public class TextareaForm implements Serializable {

	private static final long serialVersionUID = 1L;

	private String opinionsAndRequests;
	public String getOpinionsAndRequests() { return opinionsAndRequests; }
	public void setOpinionsAndRequests(String value) { this.opinionsAndRequests = value; }
}
