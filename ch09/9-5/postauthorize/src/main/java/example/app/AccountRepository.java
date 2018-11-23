package example.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
		String sql = "SELECT username, password, enabled, admin,"
					+ " user_uuid, last_name, department_code, department_manager"
					+ " FROM account WHERE username = ?";
		AccountRowMapper rowMapper = new AccountRowMapper();
		try {
			return jdbcTemplate.queryForObject(sql, rowMapper, username);
		}
		catch (EmptyResultDataAccessException ex) {
			return null;
		}
	}
	
	// 2018.11.18 add: see p.115
	public List<String> getAllUsernames() {
		String sql = "SELECT username FROM account";
		List<Map<String, Object>> resultList = jdbcTemplate.queryForList(sql);
		List<String> usernameList = new ArrayList<>();
		for (Map<String, Object> result: resultList) {
			usernameList.add((String)result.get("username"));
		}
		return usernameList;
	}
}
