@Google_Search_Testing
Feature: testing the searching feature with data driven approach

  @ToWorkAt
  Scenario: Open google and work in it
    Given Browser is opened
    When Open google website
    And Enter details with data E:\searchData.xlsx
