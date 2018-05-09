package example.app;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service("accountService")
public class AccountServiceImpl implements AccountService {
	private Map<String,Account> accountsMap = new HashMap<String, Account>();
	
	public AccountServiceImpl() {
		Account ac1 = new Account("1", "sasaki", "sasaki-seiji@msj.biglobe.ne.jp");
		accountsMap.put(ac1.getId(), ac1);

		Account ac2 = new Account("2", "someone", "someone@example.com");
		accountsMap.put(ac2.getId(), ac2);
	}

	@Override
	public Account getAccount(String accountId) {
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
