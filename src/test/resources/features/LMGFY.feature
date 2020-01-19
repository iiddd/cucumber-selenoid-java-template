Feature: 1. Search with Google

  Scenario Outline: 1.1 Search for LinkedIn website at Google

    Given navigate to Google website
    And check that user is on Google main page
    When User enters "<Text>" to search field
    And User clicks search button
    Then User is on results page
    And "<Text>" element is in the list

    Examples:
      | Text     |
      | LinkedIn |
      | Mendix   |

  Scenario: 1.2 Search for Impossible data

    Given navigate to Google website
    And check that user is on Google main page
    When User enters random string to search field
    And User clicks search button
    Then User is on results page
    And No results found