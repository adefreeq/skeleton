package pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.util.StringUtils;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public abstract class BasePage {

    protected WebDriver driver;
    private final int TIMEOUT_SECONDS = 10;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public abstract String getPageUrl();

    public void navigateToPage(String url) {
        log.info("Navigating to URL: {}", url);
        driver.get(url);
    }

    protected WebDriverWait getWebDriverWait() {
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_SECONDS));
    }

    protected WebElement findElement(By by) {
        log.debug("Finding element by: {}", by);
        return getWebDriverWait().until(ExpectedConditions.presenceOfElementLocated(by));
    }

    protected WebElement findElement(WebElement element) {
        log.debug("Validating presence of WebElement: {}", element);
        getWebDriverWait().until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    protected WebElement findRelationalElement(WebElement parent, By childLocator) {
        log.debug("Finding relational element under parent: {}", parent);
        return parent.findElement(childLocator);
    }

    protected void click(WebElement element) {
        log.info("Clicking element: {}", element);
        findElement(element).click();
    }

    protected void lazyClick(By by) {
        log.info("Lazy clicking element by: {}", by);
        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(by)).click();
    }

    protected void sendKeys(WebElement element, String keys) {
        log.info("Sending keys '{}' to element: {}", keys, element);
        WebElement el = findElement(element);
        el.clear();
        el.sendKeys(keys);
    }

    protected void clear(WebElement element) {
        log.info("Clearing input element: {}", element);
        findElement(element).clear();
    }

    protected String getText(WebElement element) {
        log.info("Getting text from element: {}", element);
        return StringUtils.trimWhitespace(findElement(element).getText());
    }

    protected String getTextFromInput(WebElement inputElement) {
        log.info("Getting 'value' attribute from input element: {}", inputElement);
        return StringUtils.trimWhitespace(findElement(inputElement).getAttribute("value"));
    }

    protected List<String> getAllTextFromWebElements(List<WebElement> elements) {
        log.info("Extracting text from list of elements...");
        return elements.stream()
                .map(e -> StringUtils.trimWhitespace(e.getText()))
                .collect(Collectors.toList());
    }

    protected void selectByVisibleText(WebElement selectElement, String visibleText) {
        log.info("Selecting '{}' in dropdown: {}", visibleText, selectElement);
        Select dropdown = new Select(findElement(selectElement));
        dropdown.selectByVisibleText(visibleText);
    }

    protected void selectByValue(WebElement selectElement, String value) {
        log.info("Selecting by value '{}' in dropdown: {}", value, selectElement);
        Select dropdown = new Select(findElement(selectElement));
        dropdown.selectByValue(value);
    }

    protected void selectByIndex(WebElement selectElement, int index) {
        log.info("Selecting by index {} in dropdown: {}", index, selectElement);
        Select dropdown = new Select(findElement(selectElement));
        dropdown.selectByIndex(index);
    }

    protected boolean isVisible(By by) {
        try {
            return getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(by)).isDisplayed();
        } catch (TimeoutException e) {
            log.warn("Element not visible: {}", by);
            return false;
        }
    }
}