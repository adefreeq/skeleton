package steps;

import context.CucumberHooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import pages.LoginPage;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class LoginSteps {

    @Autowired
    private CucumberHooks hooks;

    @Autowired
    private LoginPage loginPage;

    private WebDriver driver;

    @Given("the user navigates to the login page")
    public void navigateToLoginPage() {
        log.info("Step: Navigating to login page");
        driver = hooks.getWebDriver();
        loginPage.navigateToLoginPage();
    }

    @When("the user enters username {string} and password {string}")
    public void enterLoginCredentials(String username, String password) {
        log.info("Step: Entering credentials: username={}, password={}", username, password);
        loginPage.withUsername(username).withPassword(password);
    }

    @And("clicks the login button")
    public void login() {
        log.info("Step: Clicking login button");
        loginPage.login();
    }

    @Then("the user should be redirected to the inventory page")
    public void verifyLogin() {
        log.info("Step: Verifying redirection to inventory page");
        String currentUrl = driver.getCurrentUrl();
        log.info("Current URL: {}", currentUrl);
        assertThat(currentUrl).contains("/inventory.html");
    }
}