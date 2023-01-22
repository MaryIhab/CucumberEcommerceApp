@App
Feature: user forgot password

  Scenario: user reset password successfully
    When user click on forgot link and enters correct email
    Then user should receive email with instructions
