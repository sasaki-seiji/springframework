package example.aspect.simple_aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("example.aspect.simple_aop")
@EnableAspectJAutoProxy
public class AppConfig {
}
