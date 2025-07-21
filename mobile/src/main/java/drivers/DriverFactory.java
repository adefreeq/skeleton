package drivers;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.net.URL;
import java.util.Map;

@Component
public class DriverFactory {

    private AppiumDriver driver;

    @Value("classpath:application.yml")
    private org.springframework.core.io.Resource configResource;

    public AppiumDriver getDriver() throws Exception {
        if (driver == null) {
            Yaml yaml = new Yaml();
            try (InputStream in = configResource.getInputStream()) {
                Map<String, Object> obj = yaml.load(in);
                String platform = (String) obj.get("platform");

                Map<String, Object> platformConfig = (Map<String, Object>) obj.get(platform);
                String appPath = String.valueOf(platformConfig.get("app"));
                String deviceName = String.valueOf(platformConfig.get("deviceName"));
                String platformVersion = String.valueOf(platformConfig.get("platformVersion"));
                String automationName = String.valueOf(platformConfig.get("automationName"));

                DesiredCapabilities caps = new DesiredCapabilities();
                caps.setCapability("platformName", "Android");
                caps.setCapability("appium:deviceName", deviceName);
                caps.setCapability("appium:platformVersion", platformVersion);
                caps.setCapability("appium:automationName", automationName);
                caps.setCapability("appium:app", appPath);
                caps.setCapability("appium:fullReset", true);
                caps.setCapability("appium:appWaitActivity", "*");
                caps.setCapability("appium:autoGrantPermissions", true);

                if (platform.equalsIgnoreCase("android")) {
                    driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), caps);
                } else {
                    driver = new IOSDriver(new URL("http://127.0.0.1:4723"), caps);
                }
            }
        }
        return driver;
    }

    public void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}