package example.aspect.named_pointcut;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import example.aspect.named_pointcut.domain.*;

@Component
@Aspect
public class NamedPointCuts {
	@Pointcut("within(example.aspect.named_pointcut.web..*)")
	public void inWebLayer() {}
	
	@Pointcut("within(example.aspect.named_pointcut.domain..*)")
	public void inDomainLayer() {}
	
	@Pointcut("execution(public * *(..))")
	public void anyPublicOperation() {}
}
