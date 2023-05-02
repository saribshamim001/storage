@tag
  Feature: Create a customer

    Background:
      Given user will login with given creds
      Then User logout

    @tag2
    Scenario Outline: Positive Test of creating a new customer
      Given user will navigate to click on new deal for customer creation
      When User will fill the form for customer creation
      And User will validate and commit the form




      Examples:
      name      |   password
      retail01  |   QWer1234