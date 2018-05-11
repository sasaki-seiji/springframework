package example.app;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service("accountService")
public class AccountServiceImpl implements AccountService {
	private Map<String,AccountCreateForm> accountsMap = new HashMap<String, AccountCreateForm>();
	
	public AccountServiceImpl() {
		AccountCreateForm ac1 = new AccountCreateForm("sasaki", "090-5199-4582", new Date(1959, 12, 25), "sasaki-seiji@msj.biglobe.ne.jp");
		accountsMap.put(ac1.getName(), ac1);

		AccountCreateForm ac2 = new AccountCreateForm("someone", "123-4567-8901", new Date(2000, 1, 1), "someone@example.com");
		accountsMap.put(ac2.getName(), ac2);
	}

	@Override
	public AccountCreateForm getAccount(String accountId) {
		return accountsMap.get(accountId);
	}

	@Override
	public boolean createAccount(AccountCreateForm account) {
		if (accountsMap.containsKey(account.getName())) {
			return false;
		}
		accountsMap.put(account.getName(), account);
		return true;
	}

}
