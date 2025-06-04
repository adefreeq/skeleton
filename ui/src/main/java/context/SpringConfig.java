package context;

import org.openqa.selenium.WebDriver;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import pages.LoginPage;

@Configuration
@EnableConfigurationProperties
@PropertySource("classpath:application.yml")
public class SpringConfig {

    @Bean
    public ScenarioContext scenarioContext() {
        return new ScenarioContext();
    }

    @Bean
    @Scope("prototype")
    public LoginPage loginPage(WebDriver webDriver) {
        return new LoginPage(webDriver);
    }

    @Bean
    @Scope("prototype")
    public WebDriver webDriver(CucumberHooks hooks) {
        return hooks.getWebDriver();
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}

