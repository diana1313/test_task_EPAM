package steps.serenity;


import io.restassured.response.Response;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.BasePage;


public class RestSteps {
    private BasePage basePage;


    @Step
    public void sendRequest (String uri){


    }

    @Step
    public void enterCredentials(String userName, String passWord){
        basePage.getAlert().sendKeys(userName + Keys.TAB.toString() + passWord + Keys.ENTER.toString());
    }

    @Step
    public void checkResponse (){


    }
}
