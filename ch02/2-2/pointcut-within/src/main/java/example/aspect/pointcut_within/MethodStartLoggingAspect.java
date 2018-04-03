package example.aspect.pointcut_within;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MethodStartLoggingAspect {
	@Before("within(example.aspect.pointcut_within.UserServiceImpl)")
	public void startLog(JoinPoint jp) {
		System.out.println("メソッド開始: " + jp.getSignature());
	}
}
