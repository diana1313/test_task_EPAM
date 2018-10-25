package steps.definitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import steps.serenity.SearchSteps;

public class SearchStepdefs {
    @Steps
    SearchSteps searchSteps;

    @Given("^open Google Search Page$")
    public void openGoogleSearchPage() {
        searchSteps.openGoogleSearchPage();
    }

    @When("^user search for (.*)$")
    public void userSearchFor(String searchData) {
        searchSteps.searchFor(searchData);
    }

    @And("^open first link from search results$")
    public void openFirstLinkFromSearchResults() {
        searchSteps.clickOnFirstLink();
    }

    @Then("^tittle on page contains (.*)$")
    public void tittleOnPageContainsSearchedWord(String searchData) {
        searchSteps.assertTittle(searchData);
    }

    @Then("^domain (.*) is present on first five search results pages$")
    public void domainIsPresentOnSearchResultsPagesPage(String domainName) {
        searchSteps.findDomainInResults(domainName);
    }
}
