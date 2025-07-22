package steps;

import context.CucumberHooks;
import io.cucumber.java.en.Then;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import pages.ProductPage;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class ProductSteps {
    @Autowired
    private CucumberHooks hooks;

    @Autowired
    private ProductPage productPage;

    private WebDriver driver;

    @Autowired
    public void setDriver(CucumberHooks hooks) {
        this.driver = hooks.getWebDriver();
    }

    @Then("the user should be redirected to the inventory page")
    public void verifyLogin() {
        log.info("Step: Verifying redirection to inventory page");
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = productPage.getPageUrl();
        log.info("Current URL: {}", currentUrl);
        log.info("Expected URL: {}", expectedUrl);
        assertThat(currentUrl).isEqualTo(expectedUrl);
    }
}