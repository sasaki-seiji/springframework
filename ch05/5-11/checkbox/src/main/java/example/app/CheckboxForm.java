package example.app;

import java.io.Serializable;

public class CheckboxForm implements Serializable {

	private static final long serialVersionUID = 1L;

	private boolean agreement = false;
	public boolean getAgreement() { return agreement; }
	public void setAgreement(boolean agreement) { this.agreement = agreement; }
}
