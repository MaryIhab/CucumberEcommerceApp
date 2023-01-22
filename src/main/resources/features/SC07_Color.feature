@App
Feature: user should be able to choose color

  Scenario: user selects color
    Given user logged in to home page to select color
    When user selects color
    Then results should be filtered with the selected color
    And End colors