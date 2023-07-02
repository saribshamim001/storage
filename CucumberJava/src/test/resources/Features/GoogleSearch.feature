Feature: Feature to search google search

  @testing
  Scenario Outline: Checking input and then clicking on
    search button works

    Given That browser is opened
    When Google is opened, I will enter a keyword to search at the <sheet> and the <row>
    And I will press Enter
    Then the other page must be opened and results should be displayed of the <sheet> and the <row>
    Then I will close the browser

    Examples: 
      | sheet | row |
      | cars    |   1 |
      | cars    |   2 |