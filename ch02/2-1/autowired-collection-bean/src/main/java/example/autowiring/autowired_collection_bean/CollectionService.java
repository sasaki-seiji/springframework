package example.autowiring.autowired_collection_bean;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CollectionService {
	@Autowired @Qualifier("ifList")
	List<IF<?>> ifList_autowired;
	@Autowired @Qualifier("ifMap")
	Map<String, IF<?>> ifMap_autowired;
	
	@Resource
	List<IF<?>> ifList_resource;
	@Resource
	Map<String, IF<?>> ifMap_resource;
}
