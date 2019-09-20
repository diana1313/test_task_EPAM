Feature: Google Search for "automation"

  Background:
    Given I open Google Search page

  Scenario Outline: Verify title in content of first link
    When I search for "<search_data>" on Google Search page
    And I open "<link_number>" link from search results on Google Result page
    Then I check that title on page contains expected <search_data>
    Examples:
      | link_number | search_data |
      | 1           | automation  |

  Scenario Outline: Verify expected domain on search result pages
    When I search for "<search_data>" on Google Search page
    Then I check that domain "<domain_name>" is present in results till <page_number> of Search Result pages
    Examples:
      | search_data | domain_name    | page_number |
      | automation  | automation.com | 3           |

  @run
  Scenario Outline: Verify expected data with soft assertions
    When I search for "<search_data>" on Google Search page
    And I open result with "<domain_name>" on Google Result page
    Then I check that present data contains expected values on Soft Asserts page:
      | label_name | value         |
      | TITLE      | <title>       |
      | AUTHOR     | <author>      |
      | EMAIL      | <email>       |
      | TIME       | <last_update> |
    Examples:
      | search_data           | domain_name     | title                                               | author              | email                  | last_update |
      | soft asserts serenity | thucydides.info | Soft Asserts using the Serenity BDD Journey Pattern | John Ferguson Smart | john.smart@wakaleo.com | 2016-02-23  |