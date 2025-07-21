package ios.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import shared.LoginPage;


public class IOSLoginPage implements LoginPage {

    private final AppiumDriver driver;

    private final By usernameField = By.name("test-Username");
    private final By passwordField = By.name("test-Password");
    private final By loginButton = By.name("test-LoginButton");
    private final By homeScreen = By.name("ios_home_screen");

    public IOSLoginPage(AppiumDriver driver) {
        this.driver = driver;
    }

    @Override
    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    @Override
    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    @Override
    public void tapLoginButton() {
        driver.findElement(loginButton).click();
    }

    @Override
    public void verifyHomeScreenDisplayed() {
        boolean isDisplayed = driver.findElement(homeScreen).isDisplayed();
        assert isDisplayed : "iOS: Home screen is not displayed";
    }
}