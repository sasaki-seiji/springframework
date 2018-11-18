package example.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountService {

	@Autowired
	AccountRepository accountRepository;

	@Transactional(readOnly = true)
	public List<String> getAllUsernames() {
		return accountRepository.getAllUsernames();
	}
	
	@Transactional(readOnly = true)
	@PreAuthorize("hasRole('ROLE_ADMIN') or (#username == principal.username)")
	public Account findOne(String username) {
		return accountRepository.findOne(username);
	}
}
