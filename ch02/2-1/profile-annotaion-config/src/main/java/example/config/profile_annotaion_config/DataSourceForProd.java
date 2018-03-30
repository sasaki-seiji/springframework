package example.config.profile_annotaion_config;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("production")
public class DataSourceForProd implements DataSource {

}
