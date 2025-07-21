package drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeSetup {

    public static WebDriver create(boolean headless) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-infobars", "--disable-notifications", "--remote-allow-origins=*");

        if (headless) {
            options.addArguments("--headless=new");
        }

        return new ChromeDriver(options);
    }
}
