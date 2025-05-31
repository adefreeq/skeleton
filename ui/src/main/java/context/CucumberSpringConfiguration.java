package context;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@CucumberContextConfiguration
@ContextConfiguration(classes = SpringConfig.class, loader = AnnotationConfigContextLoader.class)
public class CucumberSpringConfiguration {
}
