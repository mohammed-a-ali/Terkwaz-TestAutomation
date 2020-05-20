package pages;

import extensions.ElementManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Example2Page extends PageBase{
    public Example2Page(WebDriver driver) {
        super(driver);
    }

    By by;
    public void clickStartButton()
    {
        //Inspect the Start button
        by = By.xpath("//*[text()='Start']");

        //Wait for the Element to be present
        ElementManager.WaitForElementPresent(by);

        //Locate the Start button to be clicked
        WebElement startButton = driver.findElement(by);

        //Click the Start button
        ElementManager.clickButton(startButton);
    }

    public boolean isFinishedLoading()
    {
        //Inspect the finish div
        by = By.id("finish");

        //Wait for the Element to be present
        ElementManager.WaitForElementPresent(by);

        //Locate the finish div to appears
        WebElement finishDiv = driver.findElement(by);

        //Assert the loader is finished
        if (finishDiv.isDisplayed())
            return true;
        else
            return false;
    }

    public String displayedText()
    {
        //Inspect the displayed text
        by = By.id("finish");

        //Wait for the Element to be present
        ElementManager.WaitForElementPresent(by);

        //Locate the text to be displayed
        WebElement displayedText = driver.findElement(by);

        return displayedText.getText();
    }
}
