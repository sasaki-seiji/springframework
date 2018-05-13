package example.app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service("accountService")
public class AccountServiceImpl implements AccountService {
	private Map<String,AccountCreateForm> accountsMap = new HashMap<String, AccountCreateForm>();
	
	public AccountServiceImpl() throws ParseException {
		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
		
		AccountCreateForm ac1 = new AccountCreateForm("sasaki", "090-5199-4582", df.parse("1959/12/25"), "sasaki-seiji@msj.biglobe.ne.jp");
		accountsMap.put(ac1.getName(), ac1);

		AccountCreateForm ac2 = new AccountCreateForm("someone", "123-4567-8901", df.parse("2000/1/1"), "someone@example.com");
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
