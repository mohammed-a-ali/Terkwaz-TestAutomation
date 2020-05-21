package APITestAutomation;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import browser.Driver;
import io.restassured.RestAssured;
import org.testng.annotations.Test;
import pages.EndPoints;
import utilities.LoadProperties;

public class GETOneRandomFact {

    String getOneRandomCatFact = EndPoints.randomAmountEndPoint("cat", "1");
    String getOneRandomCatFactEP = LoadProperties.environment.getProperty("APIURL") + getOneRandomCatFact;

    @Test
    public void GetRandomCatFact() {

        //Create test for the Extent Report
        Driver.test = Driver.extent.createTest("GET one random cat fact");

        given().
                get(getOneRandomCatFactEP).
                then().
                statusCode(200).
                assertThat().
                body("text", notNullValue()).
                log().all();
    }
}
