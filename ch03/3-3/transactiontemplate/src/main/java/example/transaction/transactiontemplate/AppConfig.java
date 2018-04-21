package example.transaction.transactiontemplate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.support.TransactionTemplate;

@Configuration
@ComponentScan
@Import(TransactionManagerConfig.class)
public class AppConfig {

	@Bean
	public TransactionTemplate transactionTemplate(
			PlatformTransactionManager transactionManager) {
		TransactionTemplate transactionTemplate = new TransactionTemplate(transactionManager);
		transactionTemplate.setIsolationLevel(TransactionDefinition.ISOLATION_READ_COMMITTED);
		transactionTemplate.setTimeout(30);
		return transactionTemplate;
	}
}
