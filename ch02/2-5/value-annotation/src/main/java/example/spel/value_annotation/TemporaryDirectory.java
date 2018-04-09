package example.spel.value_annotation;

import java.io.File;
import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TemporaryDirectory implements Serializable {
	private static final long serialVersionUID = 1l;
	private final File directory;
	
	@Autowired
	public TemporaryDirectory(
			@Value("file://#{systemProperties['java.io.tmpdir']}/app") File baseDirectory,
			@Value("#{T(java.util.UUID).randomUUID().toString()}") String id) {
		this.directory = new File(baseDirectory, id);
	}
	File getDirectory() { return directory; }
}
