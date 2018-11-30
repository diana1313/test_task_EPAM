Feature: First REST Test

  Scenario Outline: Authorization to http://restapi.demoqa.com/authentication/CheckForAuthentication
    When request <uri> is send
    And credentials are entered <userName>,<passWord>
    Then response is successful and contains private information

    Examples:
      | uri                                                             | userName | passWord     |
      | http://restapi.demoqa.com/authentication/CheckForAuthentication | ToolsQA  | TestPassword |