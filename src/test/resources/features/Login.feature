Feature: Verify Login Functionality

  Scenario: Verify user can login in the website
    Given user opens the website
    Then verify user is on login page
    When user enters username "valid.username" and password "valid.password"
    Then verify user is on home page