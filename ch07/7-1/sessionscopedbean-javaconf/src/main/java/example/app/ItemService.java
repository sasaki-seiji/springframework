package example.app;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

@Service
public class ItemService {

	private final Map<String,Item> mapItems = new TreeMap<>(); 

	@PostConstruct
	public void setupData() {
		mapItems.put("001", new Item("001", "Item#1", 100));
		mapItems.put("002", new Item("002", "Item#2", 200));
		mapItems.put("003", new Item("003", "Item#3", 300));
		mapItems.put("004", new Item("004", "Item#4", 400));
	}
	
	public Collection<Item> getAllItems() {
		return mapItems.values();
	}
	
	public Item get(String id) {
		Item item = mapItems.get(id);
		return item;
	}
}
