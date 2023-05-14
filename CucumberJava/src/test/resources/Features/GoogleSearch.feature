Feature: Feature to search google search

  @testing
  Scenario: Checking input and then clicking on
    search button works

    Given That browser is opened
    When Google is opened, I will enter a keyword to search
    And I will press Enter
    Then the other page must be opened and results should be displayed
    Then I will close the browser
