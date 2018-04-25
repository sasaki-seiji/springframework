package example.jdbc.beanpropertysqlparametersource_pg;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	try(ConfigurableApplicationContext context 
    			= new ClassPathXmlApplicationContext("JdbcTemplateConfig.xml")) {
    		NamedParameterJdbcTemplate template = context.getBean("namedParameterJdbcTemplate", NamedParameterJdbcTemplate.class);

    		Room room = new Room("A001", "幹部用会議室", 10);
    		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(room);
    		String sql = "SELECT COUNT(*) FROM room WHERE room_id = :roomId AND room_name = :roomName AND capacity = :capacity";
    		int count = template.queryForObject(sql,  params,  Integer.class);
    		System.out.println("count: " + count);
    	}
    }
}
