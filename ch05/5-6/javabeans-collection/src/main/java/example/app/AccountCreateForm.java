package example.app;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AccountCreateForm implements Serializable {

	private static final long serialVersionUID = 1L;

	private AccountForm account;
	private List<CardForm> cards;

	public AccountCreateForm(AccountForm account, List<CardForm> cards) {
		this.account = account;
		this.cards = cards;
	}
	public AccountCreateForm() {
		this.account = new AccountForm();
		this.cards = new ArrayList<CardForm>();
	}
	
	public AccountForm getAccount() { return account; }
	public List<CardForm> getCards() { return cards; }
}
