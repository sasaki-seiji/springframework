package example.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class MessageRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	// use BeanPropertyRowMapper
	// see 3.2.3: p120
	public List<Message> getAllMessages() {
		String sql = "SELECT id, message FROM message";
		RowMapper<Message> rowMapper = new BeanPropertyRowMapper<Message>(Message.class);
		return jdbcTemplate.query(sql, new Object[0], rowMapper);
	}

	// see 3.2.2: page 117
	public int addMessage(String message) {
		String sql = "INSERT INTO message(message) VALUES(?)";
		return jdbcTemplate.update(sql, message);
	}
}
