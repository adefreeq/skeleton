package shared;

public interface LoginPage {
    void enterUsername(String username);
    void enterPassword(String password);
    void tapLoginButton();
    void verifyHomeScreenDisplayed();
}