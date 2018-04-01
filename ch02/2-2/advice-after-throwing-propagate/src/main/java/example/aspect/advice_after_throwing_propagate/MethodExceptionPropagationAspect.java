package example.aspect.advice_after_throwing_propagate;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MethodExceptionPropagationAspect {
	@AfterThrowing(value = "execution(* *..*ServiceImpl.*(..))", throwing = "e")
	public void endLog(JoinPoint jp, DataAccessException e) {
		throw new ApplicationException(e);
	}
}
