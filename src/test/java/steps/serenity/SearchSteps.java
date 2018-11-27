package steps.serenity;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import pages.GoogleSearchPage;
import pages.GoogleSearchResultPage;
import pages.SoftAssertsPage;

import java.util.Optional;

public class SearchSteps {
    private GoogleSearchPage googleSearchPage;
    private GoogleSearchResultPage googleSearchResultPage;
    private SoftAssertsPage softAssertsPage;

    @Step
    public void openPageWithDomainName(String domainName){
        googleSearchResultPage.searchDomainInResults(domainName).get().click();
    }

    @Step
    public void openGoogleSearchPage() {
        googleSearchPage.open();
    }

    @Step
    public void searchFor(String searchData) {
        googleSearchPage.searchInput()
                .typeAndEnter(searchData);
    }

    @Step
    public void clickOnFirstLink() {
        googleSearchResultPage.searchResultsTittles()
                .get(0)
                .click();
    }

    @Step
    public boolean checkIfTitleMatch(String searchData) {
        return googleSearchResultPage.getTitle()
                .toLowerCase()
                .contains(searchData);
    }

    @Step
    public boolean checkDomainPresenceInResults(String domainName, int pagesCountToCheck) {
        int count = 1;
        while (count < pagesCountToCheck) {

            Optional<WebElementFacade> resultOptional = googleSearchResultPage.searchDomainInResults(domainName);
            if (resultOptional.isPresent()) {
                System.out.println("Element found");
                resultOptional.get().isPresent();
                return true;
            }

            googleSearchResultPage.buttonNextPage().click();
            count++;

            if (count > pagesCountToCheck) {
                System.out.println("Reached last page");
            }

        }
        return false;
    }

}