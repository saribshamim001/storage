Feature: Making reservation at Adactin Hotel

  @smoke
  Scenario: Successful Reservation
  
    Given Browser and link is opened
    When I enter correct credentials
    Then I must be logged to continue reservation
    And I will fill all the details
    Then in the end order number must be generated
    Then I will close the browser in end

