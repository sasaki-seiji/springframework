package example.app;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service("accountService")
public class AccountServiceImpl implements AccountService {
	private Map<String,Account> accountsMap = new HashMap<String, Account>();
	
	public AccountServiceImpl() {
		Account ac1 = new Account();
		ac1.setId("1");
		ac1.setName("sasaki");
		ac1.setEmail("sasaki-seiji@msj.biglobe.ne.jp");
		accountsMap.put(ac1.getId(), ac1);

		Account ac2 = new Account();
		ac2.setId("2");
		ac2.setName("someone");
		ac2.setEmail("someone@example.com");
		accountsMap.put(ac2.getId(), ac2);
	}

	@Override
	public Account getAccount(String accountId) {
		return accountsMap.get(accountId);
	}

}
