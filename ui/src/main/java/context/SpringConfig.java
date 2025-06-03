package context;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "ui")
public class SpringConfig {

    @Bean
    public ScenarioContext scenarioContext() {
        return new ScenarioContext();
    }
}
