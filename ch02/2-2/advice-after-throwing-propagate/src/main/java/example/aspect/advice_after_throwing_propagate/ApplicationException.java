package example.aspect.advice_after_throwing_propagate;

public class ApplicationException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	RuntimeException org;
	public ApplicationException(RuntimeException e) {
		this.org = e;
	}
}
