package example.app;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import javax.validation.groups.Default;


public class AccountCreateForm implements Serializable {

	private static final long serialVersionUID = 1L;

	public static interface FreeAccount extends Default { }
	public static interface PayAccount extends Default { }
//	public static interface FreeAccount { }
//	public static interface PayAccount { }
	
	@Size(min = 1)
	private String name;
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

	@Size(min = 1, max = 1)
	private String type;
	public String getType() { return type; }
	public void setType(String type) { this.type = type; }

	@Size.List({
		@Size(max = 0, groups = FreeAccount.class),
		@Size(min = 14, max = 16, groups = PayAccount.class)
	})
	private String cardNo;
	public String getCardNo() { return cardNo; }
	public void setCardNo(String cardNo) { this.cardNo = cardNo; }
}
