package example.app;

import java.io.Serializable;

public class Item implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	public String getId() { return id; }
	
	private String name;
	public String getName() { return name; }
	
	private int prise;
	public int getPrise() { return prise; }
	
	public Item() { }
	public Item(String id, String name, int prise) {
		this.id = id;
		this.name = name;
		this.prise = prise;
	}
	
	@Override
	public String toString() {
		return "Item:{id=" + id + ", name=" + name + ", prise=" + prise +"}";
	}
}
