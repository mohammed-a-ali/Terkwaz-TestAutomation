package pages;

import extensions.ElementManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultsPage extends PageBase {
    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    By byXpath;

    public boolean thirdResult() {
        //Inspect the Third result
        byXpath = By.xpath("(//h3[contains(text(),'WebDriver')])[4]");
        //Wait for the element to be present
        ElementManager.WaitForElementPresent(byXpath);
        //Locate the third result element
        WebElement textElement = driver.findElement(byXpath);
        //Making sure that the third result text contains "What is Selenium WebDriver?"
        if (textElement.getText().contains("What is Selenium WebDriver?"))
        {
            return true;
        } else return false;
    }
}
