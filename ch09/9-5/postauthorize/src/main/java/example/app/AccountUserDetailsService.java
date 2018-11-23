package example.app;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountUserDetailsService implements UserDetailsService {

	@Autowired
	AccountRepository accountRepository;
	
	
	@Transactional(readOnly = true)
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Account account = Optional.ofNullable(accountRepository.findOne(username))
				.orElseThrow(() -> new UsernameNotFoundException("user not found"));
		return new AccountUserDetails(account, getAuthorities(account));
	}

	private Collection<GrantedAuthority> getAuthorities(Account account) {
		StringBuffer authorities = new StringBuffer("ROLE_USER");
		
		if (account.isAdmin()) {
			authorities.append(',');
			authorities.append("ROLE_ADMIN");
		}
		if (account.isDepartmentManager()) {
			authorities.append(',');
			authorities.append("ROLE_DEPARTMENT_MANAGER");
		}
		return AuthorityUtils.commaSeparatedStringToAuthorityList(authorities.toString());
	}
}
