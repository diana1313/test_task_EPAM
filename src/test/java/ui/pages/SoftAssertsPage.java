package ui.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class SoftAssertsPage extends PageObject {

    @FindBy(id = "author")
    private WebElementFacade authorName;

    @FindBy(id = "email")
    private WebElementFacade authorEmail;

    @FindBy(id = "footer-text")
    private WebElementFacade lastUpdateTime;

    public WebElementFacade lastUpdateTime() {
        return lastUpdateTime;
    }

    public WebElementFacade authorEmail() {
        return authorEmail;
    }

    public WebElementFacade authorName() {
        return authorName;
    }

}
