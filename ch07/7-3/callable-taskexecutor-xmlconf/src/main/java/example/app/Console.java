package example.app;

import java.time.LocalDateTime;

public class Console {
	public static void println(Object target) {
		System.out.println(LocalDateTime.now() + " " + Thread.currentThread() + ": " + target);
	}
}
