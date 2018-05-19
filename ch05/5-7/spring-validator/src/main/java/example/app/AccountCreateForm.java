package example.app;

import java.io.Serializable;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;


public class AccountCreateForm implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotEmpty
	private String name;
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

	@Size(min = 1, max = 1)
	private String type;
	public String getType() { return type; }
	public void setType(String type) { this.type = type; }

	private String cardNo;
	public String getCardNo() { return cardNo; }
	public void setCardNo(String cardNo) { this.cardNo = cardNo; }
}
