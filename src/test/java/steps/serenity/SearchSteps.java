package steps.serenity;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebDriverException;
import pages.GoogleSearchPage;
import pages.GoogleSearchResultPage;
import pages.SoftAssertsPage;

import java.util.Optional;

public class SearchSteps {
    private GoogleSearchPage googleSearchPage;
    private GoogleSearchResultPage googleSearchResultPage;
    private SoftAssertsPage softAssertsPage;

    @Step
    public void openPageWithDomainName(String domainName) {
        googleSearchResultPage.getSearchDomainInResults(domainName).get().click();
    }

    @Step
    public String getTextOfLabelWithName(String labelName) {
        switch (labelName) {
            case "TITLE":
                return softAssertsPage.getTitle();
            case "EMAIL":
                return softAssertsPage.getAuthorEmail().getText();
            case "AUTHOR":
                return softAssertsPage.getAuthorName().getText();
            case "TIME":
                return softAssertsPage.getLastUpdateTime().getText();
            default:
                throw new WebDriverException(String.format("Label with name '%s' does not much to any on page.", labelName));
        }
    }

    @Step
    public void openGoogleSearchPage() {
        googleSearchPage.open();
    }

    @Step
    public void searchFor(String searchData) {
        googleSearchPage.searchInput().typeAndEnter(searchData);
    }

    @Step
    public void clickOnLinkWithNumber(int linkNumber) {
        googleSearchResultPage.getSearchResultsTittles()
                .get(linkNumber - 1)
                .click();
    }

    @Step
    public boolean checkIfTitleMatch(String searchData) {
        return googleSearchResultPage.getTitle()
                .toLowerCase()
                .contains(searchData.toLowerCase());
    }

    @Step
    public boolean checkDomainPresenceInResults(String domainName, int pagesCountToCheck) {
        int count = 1;
        while (count < pagesCountToCheck) {
            Optional<WebElementFacade> resultOptional = googleSearchResultPage.getSearchDomainInResults(domainName);
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