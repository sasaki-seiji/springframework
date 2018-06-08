package example.app;

import java.io.Serializable;

public class HiddenForm implements Serializable {

	private static final long serialVersionUID = 1L;

	private int acceptNo;
	public int getAcceptNo() { return acceptNo; }
	public void setAcceptNo(int acceptNo) { this.acceptNo = acceptNo; }
}
