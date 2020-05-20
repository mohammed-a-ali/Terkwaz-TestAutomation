package pages;

import extensions.ElementManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DynamicLoadingPage extends PageBase{
    public DynamicLoadingPage(WebDriver driver) {
        super(driver);
    }

    By byXpath;

    public void clickExampleLink(String exampleName)
    {
        //Inspect the linkText
        byXpath = By.xpath("//a[contains(text(),'"+exampleName+"')]");

        //Wait for the Element to be present
        ElementManager.WaitForElementPresent(byXpath);

        //Locate the example to be clicked
        WebElement linkElement = driver.findElement(byXpath);

        //Click the example
        ElementManager.clickButton(linkElement);
    }
}
