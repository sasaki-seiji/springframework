package example.config;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.stereotype.Component;

@Component
public class AppSettings implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Value("${basicPostage:1250}")
	@NumberFormat(style = NumberFormat.Style.NUMBER)
	private int basicOneDayCost;
	
	public int getBasicOneDayCost() { return basicOneDayCost; }
}
