package steps.serenity;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import pages.GoogleSearchPage;
import pages.GoogleSearchResultPage;

import java.util.Optional;

public class SearchSteps {
    GoogleSearchPage googleSearchPage;
    GoogleSearchResultPage googleSearchResultPage;
    int count = 0;

    @Step
    public void openGoogleSearchPage() {
        googleSearchPage.open();
    }

    @Step
    public void searchFor(String searchData) {
        googleSearchPage.searchInput().typeAndEnter(searchData);
    }

    @Step
    public void clickOnFirstLink() {
        googleSearchResultPage.searchResultsTittles().get(0).click();
    }

    @Step
    public void assertTittle(String searchData) {
        assert googleSearchResultPage.tittleOfFirstResultPage().getText().toLowerCase().contains(searchData);
    }

    @Step
    public void findDomainInResults(String domainName) {

        while (count <= 4) {

            Optional<WebElementFacade> resultOptional = googleSearchResultPage.searchDomainInResults(domainName);
            if (resultOptional.isPresent()) {
                System.out.println("Element found");
                resultOptional.get().isPresent();
                assert true;
                return;
            }

            googleSearchResultPage.buttonNextPage().click();
            count++;

            if (count > 4) {
                assert false;
                System.out.println("Reached last page");
            }

        }
    }

}
