package context;

import drivers.DriverConfig;
import drivers.WebDriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
@Getter
public class CucumberHooks {

    private WebDriver webDriver;

    @Autowired
    private DriverConfig driverConfig;

    @Before
    public void before() {
        log.info("Starting Cucumber with browser: {} | headless: {}", driverConfig.getBrowser(), driverConfig.isHeadless());
        webDriver = WebDriverFactory.getDriver(driverConfig.getBrowser(), driverConfig.isHeadless());
    }

    @After
    public void after(Scenario scenario) {
        if (scenario.isFailed()) {
            log.info("Taking full screenshot...");
            byte[] src = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(src, "image/png", "screenshot");
        }
        log.info("Quitting current webdriver...");
        //webDriver.quit();
    }
}