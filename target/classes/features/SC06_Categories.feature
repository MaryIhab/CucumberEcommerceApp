@App
Feature: user should be able to choose category

  Scenario: user selects category
    Given user logged in to home page to select category
    When user selects category
    Then category should be displayed
    And End categories
