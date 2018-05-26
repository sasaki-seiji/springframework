package example.app;

public interface AccountService {
	public Account findOne(String accountId);
	public boolean createAccount(Account account);
}
