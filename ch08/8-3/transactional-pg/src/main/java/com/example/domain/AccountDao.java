package com.example.domain;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class AccountDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public int insertAccount(Account account) {
		String sql = "INSERT INTO account(id, name) VALUES(?, ?)";
		return jdbcTemplate.update(sql, account.getId(), account.getName());
	}
	
	public Account getAccountById(String id) {
		String sql = "SELECT id, name FROM account WHERE id = ?";
		Map<String, Object> result = jdbcTemplate.queryForMap(sql, id);
		Account account = new Account();
		account.setId((String)result.get("id"));
		account.setName((String)result.get("name"));
		return account;
	}
}
