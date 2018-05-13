package example.app;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

public class ValidationForm implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotNull
	private String notNullString;
	public String getNotNullString() { return notNullString; }
	public void setNotNullString(String v) { this.notNullString = v; }
	
	@NotEmpty
	private String notEmptyString;
	public String getNotEmptyString() { return notEmptyString; }
	public void setNotEmptyString(String v) { this.notEmptyString = v; }
	
	@NotBlank
	private String notBlankString;
	public String getNotBlankString() { return notBlankString; }
	public void setNotBlankString(String v) { this.notBlankString = v; }

	@Size(max = 10)
	private String max10String;
	public String getMax10String() { return max10String; }
	public void setMax10String(String v) { this.max10String = v; }
	
	@Pattern(regexp = "[a-zA-Z0-9]*")
	private String alnumString;
	public String getAlnumString() { return alnumString; }
	public void setAlnumString(String v) { this.alnumString = v; }
	
	@Min(1)
	@Max(100)
	private int min1Max100Int;
	public int getMin1Max100Int() { return min1Max100Int; }
	public void setMin1Max100Int(int v) { this.min1Max100Int = v; }

	@Past
	@DateTimeFormat(pattern = "yyyyMMdd")
	private Date pastDate;
	public Date getPastDate() { return pastDate; }
	public void setPastDate(Date v) { this.pastDate = v; }
	
	@AssertTrue
	private boolean isAgreed;
	public boolean getIsAgreed() { return isAgreed; }
	public void setIsAgreed(boolean v) { this.isAgreed = v; }
}
