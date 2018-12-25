package com.example.audit_pg;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.AuditorAware;

public class OsUserAuditorAware implements AuditorAware<String> {

	@Value("#{ systemProperties['user.name'] }")
	private String userName;
	
	@Override
	public Optional<String> getCurrentAuditor() {
		return Optional.of(userName);
	}

}
