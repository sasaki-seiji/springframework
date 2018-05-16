package example.app;

import java.io.Serializable;

import javax.validation.Valid;

public class AccountCreateForm implements Serializable {

	private static final long serialVersionUID = 1L;

	@Valid
	private AccountForm account;
	@Valid
	private CardForm card;

	public AccountCreateForm(AccountForm account, CardForm card) {
		this.account = account;
		this.card = card;
	}
	public AccountCreateForm() {
		this.account = new AccountForm();
		this.card = new CardForm();
	}
	
	public AccountForm getAccount() { return account; }
	public CardForm getCard() { return card; }
}
