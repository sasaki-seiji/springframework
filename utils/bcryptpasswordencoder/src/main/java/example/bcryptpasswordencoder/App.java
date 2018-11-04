package example.bcryptpasswordencoder;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.security.crypto.password.PasswordEncoder;

public class App 
{
    public static void main( String[] args )
    {
    	try(ConfigurableApplicationContext context 
    			= new AnnotationConfigApplicationContext(AppConfig.class)) {
    		PasswordEncoder encoder = context.getBean(PasswordEncoder.class);
    		
    		for (int i = 0; i < args.length; i++) {
    			String hash = encoder.encode(args[i]);
    			System.out.println(args[i]+':');
    			System.out.println(hash);
    		}
    	}
    }
}
