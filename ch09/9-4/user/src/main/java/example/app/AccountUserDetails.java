package example.app;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class AccountUserDetails extends User {

	private static final long serialVersionUID = 1L;
	private final Account account;
	
	// see https://docs.spring.io/spring-security/site/docs/4.2.12.RELEASE/apidocs/org/springframework/security/core/userdetails/User.html
	public AccountUserDetails(
			Account account, Collection<GrantedAuthority> authorities) {
		super(account.getUsername(), account.getPassword(),
				account.isEnabled(), true, true, true, authorities);
		this.account = account;
	}
	
	public Account getAccount() {
		return account;
	}

}
