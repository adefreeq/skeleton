package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class ProductPage extends BasePage {

    @Value("${productUrl}")
    private String url;

    @FindBy(xpath = "//span[@class='title']")
    private WebElement productsHeader;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getPageUrl() {
        return url;
    }

    public ProductPage navigateToProductPage() {
        navigateToPage(url);
        return this;
    }

    public String getProductsHeaderText() {
        return getText(productsHeader);
    }

    public boolean isProductsHeaderVisible() {
        return findElement(productsHeader).isDisplayed();
    }
}