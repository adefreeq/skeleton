package steps;

import android.pages.AndroidLoginPage;
import drivers.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import ios.pages.IOSLoginPage;
import shared.LoginPage;
import org.springframework.beans.factory.annotation.Autowired;

public class LoginSteps {

    @Autowired
    private DriverFactory driverFactory;

    private LoginPage loginPage;

    @Given("the app is launched")
    public void launchApp() throws Exception {
        AppiumDriver driver = driverFactory.getDriver();
        String platform = driver.getCapabilities().getPlatformName().toString().toLowerCase();

        if ("android".equals(platform)) {
            loginPage = new AndroidLoginPage(driver);
        } else if ("ios".equals(platform)) {
            loginPage = new IOSLoginPage(driver);
        } else {
            throw new RuntimeException("Unsupported platform: " + platform);
        }
    }

    @When("the user enters username {string} and password {string}")
    public void enterCredentials(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @And("taps the login button")
    public void tapLogin() {
        loginPage.tapLoginButton();
    }

    @Then("the user should see the home screen")
    public void verifyHomeScreen() {
        loginPage.verifyHomeScreenDisplayed();
    }
}