package example.jdbc.jdbctemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JdbcUserDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public String findUserName(String userId) {
		String sql = "SELECT user_name FROM user WHERE user_id = ?";
		return jdbcTemplate.queryForObject(sql, String.class, userId);
	}
}
