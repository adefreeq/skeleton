package drivers;

import org.openqa.selenium.WebDriver;

public class WebDriverFactory {
    public static WebDriver getDriver(String browser) {
        return switch (browser.toLowerCase()) {
            case "chrome" -> ChromeSetup.create();
            case "firefox" -> FirefoxSetup.create();
            default -> throw new IllegalArgumentException("Unsupported browser: " + browser);
        };
    }
}
