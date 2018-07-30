package example.app;

import java.util.concurrent.Callable;

import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.async.CallableProcessingInterceptor;
//import org.springframework.web.context.request.async.CallableProcessingInterceptorAdapter;

// 2018.07.30 change for deprecated
//public class CustomCallableProcessingInterceptor extends CallableProcessingInterceptorAdapter {
public class CustomCallableProcessingInterceptor implements CallableProcessingInterceptor {

	@Override
	public <T> Object handleTimeout(NativeWebRequest request, Callable<T> task) {
		return "error/timeoutError";
	}
}
