package steps.definitions;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import steps.serenity.SearchSteps;

import java.util.Map;

public class SearchStepDef {

    @Steps
    private SearchSteps searchSteps;

    @Given("^I open Google Search page$")
    public void iOpenGoogleSearchPage() {
        searchSteps.openGoogleSearchPage();
    }

    @When("^I search for \"?([^\"]*)\"? on Google Search page$")
    public void iSearchForDataOnGoogleSearchPage(String searchData) {
        searchSteps.searchFor(searchData);
    }

    @Then("^I open \"?([^\"]*)\"? link from search results on Google Result page$")
    public void iOpenLinkFromSearchResultsOnGoogleResultsPage(int linkNumber) {
        searchSteps.clickOnLinkWithNumber(linkNumber);
    }

    @Then("^I check that title on page contains expected \"?([^\"]*)\"?$")
    public void iCheckThatTitleOnPageContainsSearchedWord(String searchData) {
        Assert.assertTrue("Title doesn't contain searched data",
                searchSteps.checkIfTitleMatch(searchData));
    }

    @Then("^I check that domain \"?([^\"]*)\"? is present in results till \"?([^\"]*)\"? of Search Result pages$")
    public void domainDomainNameIsPresentOnFirstSearchResultsPages(String domainName, int pagesCountToCheck) {
        Assert.assertTrue("Domain is not found in results",
                searchSteps.checkDomainPresenceInResults(domainName, pagesCountToCheck));
    }

    @And("^I open result with \"?([^\"]*)\"? on Google Result page$")
    public void iOpenResultWithDomainNameOnGoogleResultsPage(String domainName) {
        searchSteps.openPageWithDomainName(domainName);
    }

    @Then("^I check that present data contains expected values on Soft Asserts page:")
    public void presentDataContainTitleAuthorEmailLastTimeUpdate(DataTable dataTable) {
        for (Map<String, String> data : dataTable.asMaps(String.class, String.class)) {
            String labelName = data.get("label_name");
            String expectedValue = data.get("value");
            String actualValue = searchSteps.getTextOfLabelWithName(labelName);
            boolean result = actualValue.contains(expectedValue);
            Assert.assertTrue(String.format("'%s' label with expected value '%s' is not present. Actual value: '%s'",
                    labelName, expectedValue, actualValue), result);
        }
    }
}
