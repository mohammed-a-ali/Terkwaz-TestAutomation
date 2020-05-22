package GUITestAutomation;

import browser.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DynamicLoadingPage;
import pages.Example2Page;
import pages.HerokuappHomePage;
import utilities.LoadProperties;


public class DynamicLoadingTest extends Driver {

    @Test
    public void dynamicLoading()
    {
        //Create test for the Extent Report
        Driver.test = Driver.extent.createTest("Dynamic Loading");

        //Create an object from HerokuappHomePage class
        HerokuappHomePage openHerokuapp = new HerokuappHomePage(driver);

        //Open herokuapp URL from Properties file
        String url = LoadProperties.environment.getProperty("Herokuapp");
        driver.navigate().to(url);

        //Create an object from DynamicLoadingPage class
        DynamicLoadingPage dynamicLoading = new DynamicLoadingPage(driver);

        //Click on "Dynamic Loading" link
        openHerokuapp.clickLinkText("Dynamic Loading");

        //Click on "Example 2" link
        dynamicLoading.clickExampleLink("Example 2");

        //Create an object from Example2Page class
        Example2Page example2 = new Example2Page(driver);

        //Click "Start" button
        example2.clickStartButton();

        //Make sure loading is finished
        Assert.assertTrue(example2.isFinishedLoading());

        //Check that the text displayed is "Hello World!"
        Assert.assertEquals(example2.displayedText(), "Hello World!");
    }
}
