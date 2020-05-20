package extensions;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import pages.PageBase;

import java.time.Duration;

public class ElementManager extends PageBase {

    public ElementManager(WebDriver driver) {
        super(driver);
    }

    public static void WaitForElementPresent(By by) {
        FluentWait fluentWait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(200))
                .ignoring(NoSuchElementException.class);
        fluentWait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public static void setTextToElement(WebElement textElement, String value) {
        textElement.sendKeys(value);
    }

    public static void clickButton(WebElement button)
    {
        button.click();
    }
}
