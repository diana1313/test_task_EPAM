Feature: Google Search for "automation"

  Scenario Outline: Verify title in content of first link
    Given open Google Search Page
    When user search for <searchData>
    Then open first link from search results
    Then title on page contains <searchData>

    Examples:
      | searchData |
      | automation |

  Scenario Outline: Verify expected domain on search result pages
    Given open Google Search Page
    When user search for <searchData>
    Then domain <domainName> is present on first <pagesCountToCheck> search results pages


    Examples:
      | searchData | domainName            | pagesCountToCheck |
      | automation | automation.com        | 3                 |
