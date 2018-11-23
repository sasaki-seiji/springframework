package example.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
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

	@PreAuthorize("hasRole('DEPARTMENT_MANAGER')")
	@PostAuthorize("(returnObject == null) " +
			"or (returnObject.departmentCode == principal.account.departmentCode)")
	@Transactional(readOnly = true)
	public Account findOne(String username) {
		return accountRepository.findOne(username);
	}
}
