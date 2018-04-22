package example.dataaccessexception.handle_exception;

public class NotFoundRoomIdException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	public NotFoundRoomIdException(String msg, Throwable cause) {
		super(msg, cause);
	}
	
}
