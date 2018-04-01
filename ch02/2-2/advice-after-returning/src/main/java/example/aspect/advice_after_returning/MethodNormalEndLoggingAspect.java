package example.aspect.advice_after_returning;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MethodNormalEndLoggingAspect {
	@AfterReturning(value = "execution(* *..*ServiceImpl.*(..))", returning = "user")
	public void endLog(JoinPoint jp, User user) {
		System.out.println("メソッド正常終了: " + jp.getSignature() + " 戻り値=" + user);
	}
}
