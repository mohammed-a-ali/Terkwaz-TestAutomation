package pages;

import extensions.ElementManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GooglePage extends PageBase{
    public GooglePage(WebDriver driver) {
        super(driver);
    }

    By byXpath;

    public void setTextToElement(String value)
    {
        byXpath = By.xpath("//input[@class='gLFyf gsfi']");
        ElementManager.WaitForElementPresent(byXpath);
        WebElement textElement = driver.findElement(byXpath);
        ElementManager.setTextToElement(textElement, value);
    }

    public void ClickSearchButton()
    {
        byXpath = By.xpath("//div[@class='FPdoLc tfB0Bf']//input[@name='btnK']");
        ElementManager.WaitForElementPresent(byXpath);
        WebElement searchButton = driver.findElement(byXpath);
        searchButton.submit();
    }

}
