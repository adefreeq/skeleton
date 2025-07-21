package drivers;

import org.openqa.selenium.WebDriver;

public class WebDriverFactory {

    public static WebDriver getDriver(String browser, boolean headless) {
        return switch (browser.toLowerCase()) {
            case "chrome" -> ChromeSetup.create(headless);
            case "firefox" -> FirefoxSetup.create(headless);
            default -> throw new IllegalArgumentException("Unsupported browser: " + browser);
        };
    }
}