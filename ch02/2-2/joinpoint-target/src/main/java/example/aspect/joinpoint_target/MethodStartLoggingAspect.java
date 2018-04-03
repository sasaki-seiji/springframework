package example.aspect.joinpoint_target;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MethodStartLoggingAspect {
	@Before("execution(* *..*ServiceImpl.*(..))")
	public void startLog(JoinPoint jp) {
		Object targetObject = jp.getTarget();
		Object thisObject = jp.getThis();
		Object[] args = jp.getArgs();
		System.out.println("targetObject: " + targetObject);
		System.out.println("thisObject: " + thisObject);
		System.out.println("args: " + args);
	}
}
