package example.scope.different_scope_inject;

public class ThreadUnsafePasswordEncoder implements PasswordEncoder {

	int count;
	
	ThreadUnsafePasswordEncoder() {
		this.count = 0;
		System.out.println("construct ThreadUnsafePasswordEncoder");
	}
	
	@Override
	public String encode(String rawPassword) {
		count++;
		return rawPassword + ":" + count;
	}

}
