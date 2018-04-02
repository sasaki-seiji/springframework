package example.aspect.advice_xml_config;

import org.aspectj.lang.JoinPoint;

public class MethodStartLoggingAspect {
	public void startLog(JoinPoint jp) {
		System.out.println("メソッド開始: " + jp.getSignature());
	}
}
