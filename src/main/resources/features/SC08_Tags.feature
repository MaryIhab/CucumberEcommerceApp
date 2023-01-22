@App
Feature: user should be able to choose tags

  Scenario: user selects tags
    When user selects tag
    Then results should be filtered with the selected tag
