package example.jdbc.jdbctemplate;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	try(ConfigurableApplicationContext context 
    			= new AnnotationConfigApplicationContext(AppConfigurationConfig.class)) {
    		JdbcUserDao userDao = context.getBean(JdbcUserDao.class);
    		String userName = userDao.findUserName("3");
    		System.out.println("userName: " + userName);
    	}
    }
}
