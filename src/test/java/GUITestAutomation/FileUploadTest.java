package GUITestAutomation;

import browser.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FileUploadPage;
import pages.HerokuappHomePage;
import utilities.LoadProperties;

public class FileUploadTest extends Driver {

    @Test
    public void uploadFile()
    {
        //Open herokuapp URL from Properties file
        String url = LoadProperties.environment.getProperty("Herokuapp");
        driver.navigate().to(url);

        //Create an object from HerokuappHomePage class
        HerokuappHomePage openHerokuapp = new HerokuappHomePage(driver);

        //Click "File Upload" link
        openHerokuapp.clickLinkText("File Upload");

        //Create an object from FileUploadPage
        FileUploadPage fileUpload = new FileUploadPage(driver);

        //Select the file to be uploaded
        fileUpload.selectFile();

        //Click on the upload file button
        fileUpload.clickUploadButton();

        //Confirm the file is uploaded
        Assert.assertTrue(fileUpload.fileUploaded());
    }

}
