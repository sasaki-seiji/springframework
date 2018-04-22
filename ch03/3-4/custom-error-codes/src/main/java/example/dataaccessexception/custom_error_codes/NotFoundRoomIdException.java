package example.dataaccessexception.custom_error_codes;

public class NotFoundRoomIdException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	public NotFoundRoomIdException(String msg, Throwable cause) {
		super(msg, cause);
	}
	
}
