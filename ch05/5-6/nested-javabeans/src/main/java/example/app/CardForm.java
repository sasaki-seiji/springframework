package example.app;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

public class CardForm implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotNull
	private String no;
	
	@NotNull
	@DateTimeFormat(pattern = "yyyy/MM")
	private Date validMonth;
	
	public CardForm(String no, Date validMonth) {
		this.no = no;
		this.validMonth = validMonth;
	}
	public CardForm() { }
	
	public String getNo() { return no; }
	public void setNo(String no) { this.no = no; }
	public Date getValidMonth() { return validMonth; }
	public void setValidMonth(Date validMonth) { this.validMonth = validMonth; }
}
