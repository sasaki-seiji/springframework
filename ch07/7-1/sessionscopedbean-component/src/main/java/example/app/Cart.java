package example.app;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Cart implements Serializable {

	private static final long serialVersionUID = 1L;

	private Map<String, ItemQuantity> itemQuantities = new TreeMap<>();
	public Collection<ItemQuantity> getContents() { 
		return itemQuantities.values(); 
	}
	
	public void incrementItem(Item item) {
		itemQuantities.compute(item.getId(), 
			(k, v) -> v == null ? new ItemQuantity(item, 1) : v.incrementQuantity());
	}
	
	public void decrementItem(Item item) {
		ItemQuantity itemQuantity = itemQuantities.get(item.getId());
		if (itemQuantity == null) return;
		
		itemQuantity.decrementQuantity();
		if (itemQuantity.getQuantity() > 0) {
			itemQuantities.put(item.getId(), itemQuantity);
		}
		else {
			itemQuantities.remove(item.getId());
		}
	}
	
	public void clearItem(String id) {
		itemQuantities.remove(id);
	}
	
	public void clearAll() {
		itemQuantities.clear();
	}
	
	public int getTotalQuantity() {
		int total = 0;
		for (ItemQuantity itemQuantity : itemQuantities.values()) {
			total += itemQuantity.getQuantity();
		}
		return total;
	}

	public int getTotalPrise() {
		int total = 0;
		for (ItemQuantity itemQuantity : itemQuantities.values()) {
			total += itemQuantity.getPrise();
		}
		return total;
	}
}
