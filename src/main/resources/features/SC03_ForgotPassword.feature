@App
Feature: user forgot password

  Scenario: user reset password successfully
    Given user navigates to home page
    When user click on forgot link and enters correct email
    Then user should receive email with instructions
    And Close
