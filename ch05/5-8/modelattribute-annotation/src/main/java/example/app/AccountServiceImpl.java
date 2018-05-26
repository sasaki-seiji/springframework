package example.app;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service("accountService")
public class AccountServiceImpl implements AccountService {
	private Map<String,Account> accountsMap = new HashMap<String, Account>();
	
	public AccountServiceImpl() {
		Account ac1 = new Account("A001", "sasaki");
		createAccount(ac1);
	}
	
	@Override
	public Account findOne(String accountId) {
		return accountsMap.get(accountId);
	}

	@Override
	public boolean createAccount(Account account) {
		if (accountsMap.containsKey(account.getId())) {
			return false;
		}
		accountsMap.put(account.getId(), account);
		return true;
	}

}
