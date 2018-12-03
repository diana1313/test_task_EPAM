Feature: First REST Test

  Scenario Outline: Basic authorization
    When basicAuth request with credentials <userName>,<passWord> is send
    Then response is successful and contains private information

    Examples:
      | userName | passWord     |
      | ToolsQA  | TestPassword |