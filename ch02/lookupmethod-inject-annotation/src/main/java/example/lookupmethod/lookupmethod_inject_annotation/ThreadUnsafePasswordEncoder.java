package example.lookupmethod.lookupmethod_inject_annotation;

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
