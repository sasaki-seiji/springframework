package example.app;

import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.context.request.async.DeferredResultProcessingInterceptor;
//import org.springframework.web.context.request.async.DeferredResultProcessingInterceptorAdapter;

// 2018.07.30 change for deprecated
//public class CustomDeferredResultProcessingInterceptor extends DeferredResultProcessingInterceptorAdapter {
public class CustomDeferredResultProcessingInterceptor implements DeferredResultProcessingInterceptor {
	@SuppressWarnings("unchecked")
	@Override
	public <T> boolean handleTimeout(NativeWebRequest request, DeferredResult<T> deferredResult) {
		deferredResult.setResult((T)"error/timeoutError");
		return false;
	}
}
