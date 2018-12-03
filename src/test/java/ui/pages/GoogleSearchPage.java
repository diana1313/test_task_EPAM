package ui.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.WhenPageOpens;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("https://www.google.com")
public class GoogleSearchPage extends PageObject {

    @WhenPageOpens
    public void maximiseScreen() {
        getDriver()
                .manage()
                .window()
                .maximize();
    }

    @FindBy(name = "q")
    private WebElementFacade searchInput;

    public WebElementFacade searchInput() {
        return searchInput;
    }

}
