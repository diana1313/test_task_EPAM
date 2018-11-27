Feature: Google Search for "automation"
  Background:
    Given open Google Search Page

  Scenario Outline: Verify title in content of first link
    When user search for <searchData>
    Then open first link from search results
    Then title on page contains <searchData>

    Examples:
      | searchData |
      | automation |

  Scenario Outline: Verify expected domain on search result pages
    When user search for <searchData>
    Then domain <domainName> is present on first <pagesCountToCheck> search results pages

    Examples:
      | searchData | domainName            | pagesCountToCheck |
      | automation | automation.com        | 3                 |

    Scenario Outline: Verify expected data with soft assertions
      When user search for <searchData>
      And user open result with <domainName>
      Then present data contain <title>,<author>,<email>,<lastTimeUpdate>

      Examples:
        | searchData | domainName            |title| author| email| lastTimeUpdate |
        | automation | thucydides.info       |     |      |      |                |