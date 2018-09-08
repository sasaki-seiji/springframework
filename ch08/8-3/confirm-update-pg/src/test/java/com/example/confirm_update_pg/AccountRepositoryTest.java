package com.example.confirm_update_pg;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.example.config.AppConfig;
import com.example.config.TestConfig;
import com.example.domain.Account;
import com.example.domain.AccountRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class, TestConfig.class})
@Sql("/account-delete.sql")
@Transactional
public class AccountRepositoryTest {

	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	@Qualifier("jdbcTemplateForAssertion")
	JdbcTemplate jdbcTemplate;
	
	@Test
	public void testCreate() {
		Account account = new Account();
		account.setId("001");
		account.setName("Spring太郎");
		int count = accountRepository.create(account);
		assertThat(count, is(1));
		
		Map<String, Object> createdAccount =
			jdbcTemplate.queryForMap("SELECT id, name FROM account WHERE id = '001'");
		
		assertThat(createdAccount.get("id"), is("001"));
		assertThat(createdAccount.get("name"), is("Spring太郎"));
	}
	
	@Test
	@Sql({"/account-delete.sql", "/account-insert-data.sql"})
	public void testFindOne() {
		Account account = accountRepository.findOne("001");
		assertThat(account.getId(), is("001"));
		assertThat(account.getName(), is("Spring太郎"));
	}
	
}
