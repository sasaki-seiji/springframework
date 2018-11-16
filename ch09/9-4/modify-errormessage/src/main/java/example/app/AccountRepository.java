package example.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class AccountRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	// use RowMapper I/F
	public Account findOne(String username) {
		// 2018.11.14 modify
		String sql = "SELECT username, password, enabled, account_non_expired, credentials_non_expired, account_non_locked, admin, user_uuid, last_name FROM account WHERE username = ?";
		AccountRowMapper rowMapper = new AccountRowMapper();
		try {
			return jdbcTemplate.queryForObject(sql, rowMapper, username);
		}
		catch (EmptyResultDataAccessException ex) {
			return null;
		}
	}
}
