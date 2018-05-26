package example.app;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service("accountService")
public class AccountServiceImpl implements AccountService {
	private Map<String,String> accountsMap = new HashMap<String, String>();
	
	public AccountServiceImpl() {
		accountsMap.put("guest", "anonymous");
		accountsMap.put("sasaki", "seiji");
	}
	
	@Override
	public boolean authenticate(LoginForm account) {
		String password = accountsMap.get(account.getUsername());
		if (password == null)
		{
			return false;
		}
		return password.equals(account.getPassword());
	}

}
