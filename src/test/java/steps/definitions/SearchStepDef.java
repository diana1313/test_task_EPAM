package steps.definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import steps.serenity.SearchSteps;

public class SearchStepDef {

    @Steps
    private SearchSteps searchSteps;

    @Given("^open Google Search Page$")
    public void openGoogleSearchPage() {
        searchSteps.openGoogleSearchPage();
    }

    @When("^user search for (.*)$")
    public void userSearchFor(String searchData) {
        searchSteps.searchFor(searchData);
    }

    @Then("^open first link from search results$")
    public void openFirstLinkFromSearchResults() {
        searchSteps.clickOnFirstLink();
    }

    @Then("^title on page contains (.*)$")
    public void titleOnPageContainsSearchedWord(String searchData) {
        Assert.assertTrue("Title doesn't contain searched data",
                searchSteps.checkIfTitleMatch(searchData));
    }

    @Then("^domain (.*) is present on first (.*) search results pages$")
    public void domainDomainNameIsPresentOnFirstSearchResultsPages(String domainName, int pagesCountToCheck) {
        Assert.assertTrue("Domain is not found in results",
                searchSteps.checkDomainPresenceInResults(domainName, pagesCountToCheck));
    }

}
