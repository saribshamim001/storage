@Google_Search_Testing
Feature: testing the searching feature with data driven approach

  @ToWorkAt
  Scenario Outline: Open google and work in it
    Given Browser is opened
    When Open google website
    And Enter details <search_item>
    And Press Enter
    Then Seach result must be displayed <search_item>

    Examples: 
      | search_item    |
      | iPhone se2    |
      | Headphones |
      | Laptop     |
