package example.app;

import java.io.Serializable;

public class OptionsForm implements Serializable {

	private static final long serialVersionUID = 1L;

	private String livingPrefecture;
	public String getLivingPrefecture() { return livingPrefecture; }
	public void setLivingPrefecture(String prefecture) 
		{ this.livingPrefecture = prefecture; }
}
