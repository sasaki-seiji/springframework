package example.app;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

@Service("accountService")
public class AccountServiceImpl implements AccountService {
	// 2018.07.18 use ConcurrentHashMap
	private Map<String,AccountCreateForm> accountsMap = new ConcurrentHashMap<String, AccountCreateForm>();
	
	@Override
	public AccountCreateForm getAccount(String accountId) {
		return accountsMap.get(accountId);
	}

	@Override
	public boolean createAccount(AccountCreateForm account) {
		if (accountsMap.containsKey(account.getId())) {
			return false;
		}
		accountsMap.put(account.getId(), account);
		return true;
	}

}
