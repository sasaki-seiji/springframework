package example.app;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.logging.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class ClientInfoMdcPutFilter extends OncePerRequestFilter {

	@Autowired
	MessageSource messageSource;

	@Override
	protected final void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		String message = messageSource.getMessage("greeting.message", new String[] {"sasaki"}, Locale.JAPANESE);
		System.out.println("DEBUG: message=" + message);
		MDC.put("greeting", "[" + message + "]");
		try {
			filterChain.doFilter(request, response);
		} finally {
			MDC.remove("greeting");
		}
	}

}
