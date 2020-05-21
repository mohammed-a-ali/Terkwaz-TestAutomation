package GUITestAutomation;

import browser.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.GooglePage;
import pages.SearchResultsPage;
import utilities.LoadProperties;
//import utilities.ExtentReport;

public class SearchTextTest extends Driver {

    static String keyWord = "selenium webdriver";

    @Test
    public void SearchText() {

//        ExtentReport extentReport = new ExtentReport();

        //Create test for the Extent Report
        Driver.test = Driver.extent.createTest("Search for selenium webdriver");

        //Open Google URL from Properties file
        String url = LoadProperties.environment.getProperty("BaseURL");
        driver.navigate().to(url);

        //Create an object from GooglePage class
        GooglePage openGoogle = new GooglePage(driver);

        //Set the keyword to the search box
        openGoogle.setTextToElement(keyWord);

        //Click Search button
        openGoogle.ClickSearchButton();

        //Create an object from Search results page
        SearchResultsPage searchResults = new SearchResultsPage(driver);
        //Making sure that the thirdResult method returns true
        Assert.assertTrue(searchResults.thirdResult());
    }
}
