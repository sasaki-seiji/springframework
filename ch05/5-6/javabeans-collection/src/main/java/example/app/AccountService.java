package example.app;

public interface AccountService {
	public AccountCreateForm getAccount(String accountId);
	public boolean createAccount(AccountCreateForm account);
}
