package steps;

import drivers.WebDriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import pages.LoginPage;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class LoginSteps {

    private final WebDriver driver;
    private LoginPage loginPage;

    @Autowired
    public LoginSteps(WebDriver driver) {
        this.driver = driver;
    }

    @Given("the user navigates to the login page")
    public void the_user_navigates_to_the_login_page() {
        loginPage = new LoginPage(driver).navigateToLoginPage();
    }

    @When("the user enters username {string} and password {string}")
    public void the_user_enters_username_and_password(String username, String password) {
        loginPage.withUsername(username).withPassword(password);
    }

    @And("clicks the login button")
    public void clicks_the_login_button() {
        loginPage.login();
    }

    @Then("the user should be redirected to the inventory page")
    public void the_user_should_be_redirected_to_the_inventory_page() {
        String currentUrl = driver.getCurrentUrl();
        assertThat(currentUrl).contains("/inventory.html");
    }
}