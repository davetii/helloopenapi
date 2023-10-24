Feature: Testing API

  Scenario Outline: hello returns expected
    When user "<name>" says hello
    Then api returns "<result>"
    Examples:
      | name | result     |
      | bob  | Hello bob  |
      | Dave | Hello Dave |

  Scenario: getAllPersons returns size of 4
    When getAllPersons is called
    Then size returned is 4

  Scenario Outline: NewPerson returns expected
    When newPerson is called with "<name>" and "<role>"
    Then api returns status "<status>"
    Examples:
      | name  | role    | status  |
      | paul  | sibling | 200     |
