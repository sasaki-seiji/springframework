package example.componentscan.scanfilter_notusedefaultfilters_xml;

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
