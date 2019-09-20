package pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Optional;

public class GoogleSearchResultPage extends PageObject {

    @FindBy(className = "iUh30")
    private List<WebElementFacade> searchResultsLinks;

    @FindBy(className = "LC20lb")
    private List<WebElementFacade> searchResultsTittles;

    @FindBy(className = "apphub_AppName")
    private WebElementFacade titleOfFirstResultPage;

    @FindBy(id = "pnnext")
    private WebElementFacade buttonNextPage;

    public WebElementFacade buttonNextPage() {
        return buttonNextPage;
    }

    public Optional<WebElementFacade> getSearchDomainInResults(String domain) {
        for (WebElementFacade domainInResult : searchResultsLinks) {
            if (domainInResult.getText().contains(domain)) {
                return Optional.of(domainInResult);
            }
        }
        return Optional.empty();
    }

    public List<WebElementFacade> getSearchResultsTittles() {
        return searchResultsTittles;
    }

    public WebElementFacade getTitleOfFirstResultPage() {
        return titleOfFirstResultPage;
    }

}
