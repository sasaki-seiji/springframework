package example.aspect.joinpoint_target_expr;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MethodStartLoggingAspect {
	@Before("execution(* *..*ServiceImpl.*(..)) && target(service) && args(input)")
	public void startLog(UserServiceImpl service, String input) {
		System.out.println("service: " + service);
		System.out.println("input: " + input);
	}
}
