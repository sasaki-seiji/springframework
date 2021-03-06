package example.aspect.named_pointcut;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import example.aspect.named_pointcut.domain.*;

@Aspect
@Component
public class MethodLoggingAspect {
	@Around("inDomainLayer()")
	public Object log(ProceedingJoinPoint jp) throws Throwable {
		System.out.println("メソッド開始: " + jp.getSignature());
		try {
			Object result = jp.proceed();
			System.out.println("メソッド正常終了: " + jp.getSignature() + " 戻り値=" + result);
			return result;
		}
		catch (Exception e) {
			System.out.println("メソッド異常終了: " + jp.getSignature());
			throw e;
		}
	}
}
