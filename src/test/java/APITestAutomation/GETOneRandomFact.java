package APITestAutomation;

import browser.Driver;
import com.aventstack.extentreports.Status;
import io.restassured.RestAssured;
import io.restassured.config.LogConfig;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pages.EndPoints;
import utilities.LoadProperties;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

import static io.restassured.RestAssured.config;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

public class GETOneRandomFact extends Driver {

    String getOneRandomCatFact = EndPoints.randomAmountEndPoint("cat", "1");
    String getOneRandomCatFactEP = LoadProperties.environment.getProperty("APIURL") + getOneRandomCatFact;

    @Test
    public void GetRandomCatFact() throws IOException {

        //Create test for the Extent Report
        Driver.test = Driver.extent.createTest("GET one random cat fact");

        //Print the response body to a text file
        config = config().logConfig(new LogConfig().defaultStream(new PrintStream(new File(System.getProperty("user.dir") + "/Reports/output.txt"))));

        given().
            get(getOneRandomCatFactEP).
        then().
            statusCode(200).
            assertThat().
            body("text", notNullValue()).
            log().all();
        //test = extent.createTest(config.logConfig(new LogConfig().enablePrettyPrinting(false)).toString());

        //Get the API response to be printed
        Response response = RestAssured.get(getOneRandomCatFactEP);
        //Get the response body
        String bodyResponse = response.getBody().asString();

        //Attaching the response body to the report
        if(response.statusCode() == 200)
        {
            test.log(Status.PASS, "Response body is: "+ bodyResponse);
        }

    }
}
