package example.app;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;

public class SessionExpiredDetectingLoginUrlAuthenticationEntryPoint extends LoginUrlAuthenticationEntryPoint {

	public SessionExpiredDetectingLoginUrlAuthenticationEntryPoint(String loginUrl) {
		super(loginUrl);
	}

	@Override
    protected String buildRedirectUrlToLoginPage(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) {

		System.err.println("buildRedirectUrlToLoginPage()");
		System.err.println(authException);
		
        String redirectUrl = super.buildRedirectUrlToLoginPage(request, response, authException);
        if (isRequestedSessionInvalid(request)) {
            redirectUrl += redirectUrl.contains("?") ? "&" : "?";
            redirectUrl += "timeout";
        }
        return redirectUrl;
    }

    private boolean isRequestedSessionInvalid(HttpServletRequest request) {
    	System.err.println("getRequestedSessionId(): " + request.getRequestedSessionId());
    	System.err.println("isRequestedSessionIdValid(): " + request.isRequestedSessionIdValid());
    	
    	return request.getRequestedSessionId() != null && !request.isRequestedSessionIdValid();
    }

}
