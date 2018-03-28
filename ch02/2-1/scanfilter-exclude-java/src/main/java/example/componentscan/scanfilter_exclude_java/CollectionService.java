package example.componentscan.scanfilter_exclude_java;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CollectionService {
	@Autowired
	List<DomainService> domainServiceList;
	
	@Autowired(required = false)
	AnotherComponent anotherComponenct;
}
