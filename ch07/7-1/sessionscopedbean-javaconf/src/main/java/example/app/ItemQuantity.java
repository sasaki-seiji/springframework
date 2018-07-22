package example.app;

import java.io.Serializable;

public class ItemQuantity implements Serializable {

	private static final long serialVersionUID = 1L;

	private Item item;
	private int quantity;
	
	public ItemQuantity() {}
	public ItemQuantity(Item item, int quantity) {
		this.item = item;
		this.quantity = quantity;
	}
	
	public Item getItem() { return this.item; }
	public void setItem(Item item) { this.item = item;}
	
	public int getQuantity() { return this.quantity; }
	public void setQuantity(int quantity) { this.quantity = quantity; }
	public ItemQuantity incrementQuantity() { 
		this.quantity++; 
		return this;
	}
	public ItemQuantity decrementQuantity() { 
		this.quantity--; 
		return this;
	}
	
	public int getPrise() {
		return item.getPrise() * quantity;
	}
}
