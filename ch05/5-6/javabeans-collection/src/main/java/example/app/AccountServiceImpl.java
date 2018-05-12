package example.app;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service("accountService")
public class AccountServiceImpl implements AccountService {
	private Map<String,AccountCreateForm> accountsMap = new HashMap<String, AccountCreateForm>();
	
	public AccountServiceImpl() throws ParseException {
		DateFormat df = new SimpleDateFormat("yyyy/MM");
		AccountForm af1 = new AccountForm("sasaki", "sasaki-seiji@msj.biglobe.ne.jp");
		List<CardForm> cfs = new ArrayList<CardForm>();
		cfs.add(new CardForm("123498765", df.parse("2020/06")));
		cfs.add(new CardForm("987654321", df.parse("2022/12")));
		AccountCreateForm ac1 = new AccountCreateForm(af1, cfs);
		accountsMap.put(ac1.getAccount().getName(), ac1);
	}

	@Override
	public AccountCreateForm getAccount(String accountId) {
		return accountsMap.get(accountId);
	}

	@Override
	public boolean createAccount(AccountCreateForm account) {
		if (accountsMap.containsKey(account.getAccount().getName())) {
			return false;
		}
		accountsMap.put(account.getAccount().getName(), account);
		return true;
	}

}
