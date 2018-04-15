package example.jdbc.mapsqlparametersource;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
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
    		MapSqlParameterSource map = new MapSqlParameterSource()
    				.addValue("roomId", "A001")
    				.addValue("roomName", "幹部用会議室")
    				.addValue("capacity", 10);
    		String sql = "SELECT COUNT(*) FROM room WHERE room_id = :roomId AND room_name = :roomName AND capacity = :capacity";
    		int count = template.queryForObject(sql,  map,  Integer.class);
    		System.out.println("count: " + count);
    	}
    }
}
