package com.example.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountRepository {

	@Autowired
	AccountDao accountDao;
	
	public int create(Account account) {
		return accountDao.insertAccount(account);
	}
	
	public Account findOne(String id) {
		return accountDao.getAccountById(id);
	}
}
