package context;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public WebDriver webDriver() {
        return new ChromeDriver();
    }

    @Bean
    public ScenarioContext scenarioContext() {
        return new ScenarioContext();
    }
}

