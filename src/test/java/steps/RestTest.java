package steps;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;
import org.openqa.selenium.Keys;
import pages.BasePage;


public class RestTest {
    private BasePage basePage;


    @Test
    public void simpleTest() {
        RestAssured.baseURI = "http://restapi.demoqa.com/authentication/CheckForAuthentication";
        RequestSpecification request = RestAssured.given().auth().preemptive().basic("ToolsQA","TestPassword");

        Response response = request.get();

        System.out.println("Status code: " + response.getStatusCode());
        System.out.println("Status message " + response.body().asString());




    }
}
