package example.app;

import java.io.Serializable;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class EchoForm implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@NotEmpty
	// 2019.05.26 change @Size(20) into @Size(max=10)
	//@Size(max=20)
	@Size(max=10)
	private String text;
	public String getText() { return text; }
	public void setText(String text) { this.text = text; }
}
