package example.config.profile_annotaion_config;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("development")
public class DataSourceForDev implements DataSource {

}
