Feature: verify the functionalities of goibibo website

  Scenario: search hotel
    Given user open goibibo website
    Then verify home page is displayed
    When user select hotel booking
    And user enters location "Chennai"
    When user clicks on search
    Then verify user is on hotel displayed page

  Scenario:Verify price of hotels are in low to high
    Given user open goibibo website
    When user select hotel booking
    And user enters location "Chennai"
    When user clicks on search
    And user clicks on price low to high
    Then verify the hotels displayed in price low to high order

  Scenario:Verify price of hotels are in high to low
    Given user open goibibo website
    When user select hotel booking
    And user enters location "Chennai"
    When user clicks on search
    And user clicks on price low to high to low
    Then verify the hotels displayed in price low to high to low order
