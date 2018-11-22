package example.app;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class AccountRowMapper implements RowMapper<Account> {

	@Override
	public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
		Account account = new Account();
		account.setUsername(rs.getString("username"));
		account.setPassword(rs.getString("password"));
		account.setEnabled(rs.getBoolean("enabled"));
		account.setAdmin(rs.getBoolean("admin"));
		// 2018.11.14 add
		account.setUserUuid(rs.getString("user_uuid"));
		account.setLastName(rs.getString("last_name"));
		return account;
	}

}
