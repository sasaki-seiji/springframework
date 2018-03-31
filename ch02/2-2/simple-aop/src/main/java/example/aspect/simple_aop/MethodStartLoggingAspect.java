package example.aspect.simple_aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MethodStartLoggingAspect {
	@Before("execution(* *..*ServiceImpl.*(..))")
	public void startLog(JoinPoint jp) {
		System.out.println("メソッド開始: " + jp.getSignature());
	}
}
