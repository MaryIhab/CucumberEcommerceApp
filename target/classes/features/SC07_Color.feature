@App
Feature: user should be able to choose color

  Scenario: user selects color
    When user selects color
    Then results should be filtered with the selected color
