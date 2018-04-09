package example.spel.xml_config;

import java.io.File;
import java.io.Serializable;

public class TemporaryDirectory implements Serializable {
	private static final long serialVersionUID = 1l;
	private final File directory;
	public TemporaryDirectory(File baseDirectory, String id) {
		this.directory = new File(baseDirectory, id);
	}
	File getDirectory() { return directory; }
}
