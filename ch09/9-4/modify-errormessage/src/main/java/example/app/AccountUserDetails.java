package example.app;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class AccountUserDetails implements UserDetails {

	private static final long serialVersionUID = 1L;
	private final Account account;
	private final Collection<GrantedAuthority> authorities;
	
	public AccountUserDetails(
			Account account, Collection<GrantedAuthority> authorities) {
		this.account = account;
		this.authorities = authorities;
	}
	
	public Account getAccount() {
		return account;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return account.getPassword();
	}

	@Override
	public String getUsername() {
		return account.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return account.isAccountNonExpired();
	}

	@Override
	public boolean isAccountNonLocked() {
		return account.isAccountNonLocked();
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return account.isCredentialsNonExpired();
	}

	@Override
	public boolean isEnabled() {
		return account.isEnabled();
	}

}
