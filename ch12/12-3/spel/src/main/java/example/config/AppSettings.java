package example.config;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AppSettings implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Value("${passwordValidDays:90}")
	private int passwordValidDays;
	
	public int getPasswordValidDays() { return passwordValidDays; }
}
