package example.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountRepository accountRepository;

	@Transactional(readOnly = true)
	public List<String> getAllUsernames() {
		return accountRepository.getAllUsernames();
	}
	
	@Transactional(readOnly = true)
	public Account findOne(String username) {
		return accountRepository.findOne(username);
	}
}
