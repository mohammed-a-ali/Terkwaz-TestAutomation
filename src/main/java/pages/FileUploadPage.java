package pages;

import extensions.ElementManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FileUploadPage extends PageBase {
    public FileUploadPage(WebDriver driver) {
        super(driver);
    }

    By byId;

    public void selectFile() {
        //File path to be uploaded
        String filePath = System.getProperty("user.dir") + "\\src\\test\\java\\data\\selenium.jpg";

        //Inspect select file element
        byId = By.id("file-upload");

        //Wait for the element to be present
        ElementManager.WaitForElementPresent(byId);

        //Locate the "select file" element
        WebElement textElement = driver.findElement(byId);
        try {
            //Enter the file path
            ElementManager.setTextToElement(textElement, filePath);
        } catch (Exception e) {
            //An error appears if the file wasn't found
            System.out.println("Error: The file wasn't found..." + "\n"+ e.getMessage());
        }
    }

    public void clickUploadButton()
    {
        //Inspect upload file button
        byId = By.id("file-submit");

        //Wait for the element to be present
        ElementManager.WaitForElementPresent(byId);

        //Locate the "Upload file" button element
        WebElement submitButton = driver.findElement(byId);

        //Click the button to upload the file
        ElementManager.clickButton(submitButton);
    }

    public boolean fileUploaded()
    {
        //Inspect upload file button
        By byXpath = By.xpath("//h3");

        //Wait for the element to be present
        ElementManager.WaitForElementPresent(byXpath);

        //Locate the "SuccessMsg" button element
        WebElement successMsg = driver.findElement(byXpath);

        //Making sure that the appeared message is successful
        if (successMsg.getText().contains("File Uploaded!"))
        {
            return true;
        } else return false;
    }
}
