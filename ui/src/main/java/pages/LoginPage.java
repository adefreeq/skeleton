package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    private final String url = "https://www.saucedemo.com/";

    @FindBy(id = "user-name")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getPageUrl() {
        return url;
    }

    public LoginPage navigateToLoginPage() {
        navigateToPage(url);  // Use the method name from BasePage
        return this;
    }

    public LoginPage withUsername(String username) {
        usernameInput.sendKeys(username);
        return this;
    }

    public LoginPage withPassword(String password) {
        passwordInput.sendKeys(password);
        return this;
    }

    public LoginPage login() {
        loginButton.click();
        return this;
    }
}
