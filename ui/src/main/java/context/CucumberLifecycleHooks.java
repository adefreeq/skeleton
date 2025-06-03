package context;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@Slf4j
public class CucumberLifecycleHooks {
    private WebDriver webDriver;

    @Before
    public void before() {
        log.info("Starting Cucumber in Spring Context");
        webDriver = new ChromeDriver();
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
        webDriver.quit();
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }
}