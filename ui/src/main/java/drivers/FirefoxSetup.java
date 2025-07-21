package drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxSetup {

    public static WebDriver create(boolean headless) {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--start-maximized", "--disable-infobars", "--disable-notifications");

        if (headless) {
            options.addArguments("--headless");
        }

        return new FirefoxDriver(options);
    }
}
