package context;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CucumberContext {
    @Bean
    public ScenarioContext scenarioContext() {
        return new ScenarioContext();
    }
}