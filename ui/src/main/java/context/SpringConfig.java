package context;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public ScenarioContext scenarioContext() {
        return new ScenarioContext();
    }
}

