package example.app;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

	private final Map<Class<? extends Exception>, String> messageMappings =
			Collections.unmodifiableMap(
				new LinkedHashMap<Class<? extends Exception>, String>() {
					private static final long serialVersionUID = 1L;
					{
						put(HttpMessageNotReadableException.class, 
							"Request body is invalid");
					}
				});
	
	private String resolveMessage(Exception ex, String defaultMessage) {
		return messageMappings.entrySet().stream()
				.filter(entry -> entry.getKey().isAssignableFrom(ex.getClass())).findFirst()
				.map(Map.Entry::getValue).orElse(defaultMessage);
	}
	
	private ApiError createApiError(Exception ex) {
		ApiError apiError = new ApiError();
		apiError.setMessage(resolveMessage(ex, ex.getMessage()));
		apiError.setDocumentationUrl("http://example.com/api/errors");
		return apiError;
	}
	
	@Override
	protected ResponseEntity<Object> handleExceptionInternal(
			Exception ex, Object body, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		ApiError apiError = createApiError(ex);
		return super.handleExceptionInternal(
				ex, apiError, headers, status, request);
	}
}
