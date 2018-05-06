package example.app;

public interface AccountService {
	public Account getAccount(String accountId);
	public boolean createAccount(Account account);
}
