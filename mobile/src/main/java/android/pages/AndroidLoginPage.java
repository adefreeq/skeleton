package android.pages;

import io.appium.java_client.AppiumDriver;
import shared.LoginPage;
import org.openqa.selenium.By;

public class AndroidLoginPage implements LoginPage {

    private final AppiumDriver driver;

    private final By usernameField = By.id("android_username");
    private final By passwordField = By.id("android_password");
    private final By loginButton = By.id("android_login_button");
    private final By homeScreen = By.id("android_home_screen");

    public AndroidLoginPage(AppiumDriver driver) {
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
        assert isDisplayed : "Android: Home screen is not displayed";
    }
}