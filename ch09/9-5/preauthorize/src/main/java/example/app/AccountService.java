package example.app;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;

public interface AccountService {

	List<String> getAllUsernames() ;

	@PreAuthorize("hasRole('ROLE_ADMIN') or (#username == principal.username)")
	Account findOne(String username) ;
}
