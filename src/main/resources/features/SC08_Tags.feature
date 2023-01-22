@App
Feature: user should be able to choose tags

  Scenario: user selects tags
    Given user logged in to home page to select tags
    When user selects tag
    Then results should be filtered with the selected tag
    And End tags
