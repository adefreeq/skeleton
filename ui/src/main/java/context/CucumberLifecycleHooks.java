package context;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
public class CucumberLifecycleHooks {

    private final WebDriver webDriver;

    @Autowired
    public CucumberLifecycleHooks(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Before
    public void before() {
        log.info("Starting Cucumber in Spring Context");
        webDriver.manage().window().maximize();
    }

    @After
    public void after(Scenario scenario) {
        if (scenario.isFailed()) {
            log.info("Taking full screenshot...");
            TakesScreenshot takesScreenshot = (TakesScreenshot) webDriver;
            byte[] src = takesScreenshot.getScreenshotAs(OutputType.BYTES);
            scenario.attach(src, "image/png", "screenshot");
        }
        log.info("Quitting current webdriver...");
        //webDriver.quit();
    }
}