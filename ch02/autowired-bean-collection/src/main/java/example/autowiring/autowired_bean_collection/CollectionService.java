package example.autowiring.autowired_bean_collection;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CollectionService {
	@Autowired
	List<IF<?>> ifList;
	@Autowired
	Map<String, IF<?>> ifMap;
	
	@Autowired
	List<IF<Integer>> intIFList;
	@Autowired
	Map<String, IF<Integer>> intIFMap;
}
