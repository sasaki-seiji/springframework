package example.app;

import java.io.Serializable;

import javax.validation.constraints.AssertTrue;

public class ErrorsForm implements Serializable {

	private static final long serialVersionUID = 1L;

	@AssertTrue
	private boolean agreement = false;
	public boolean getAgreement() { return agreement; }
	public void setAgreement(boolean agreement) { this.agreement = agreement; }

}
