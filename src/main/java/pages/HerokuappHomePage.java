package pages;

import extensions.ElementManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HerokuappHomePage extends PageBase{
    public HerokuappHomePage(WebDriver driver) {
        super(driver);
    }

    By byXpath;

    public void clickLinkText(String linkText)
    {
        byXpath = By.xpath("//*[text()='"+linkText+"']");
        ElementManager.WaitForElementPresent(byXpath);
        WebElement textElement = driver.findElement(byXpath);
        ElementManager.clickButton(textElement);
    }
}
