package example.app;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service("accountService")
public class AccountServiceImpl implements AccountService {
	private Map<String,AccountCreateForm> accountsMap = new HashMap<String, AccountCreateForm>();
	
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
