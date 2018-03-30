package example.config.jsr330_java_config;

public interface PasswordEncoder {
	String encode(String rawPassword);
}
