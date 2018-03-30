package example.config.jsr330_xml_config;

public interface PasswordEncoder {
	String encode(String rawPassword);
}
