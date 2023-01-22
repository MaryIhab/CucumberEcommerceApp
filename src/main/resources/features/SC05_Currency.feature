@App
Feature: user should be able to change currency

  Scenario: user changes currency
    Given user logged in to home page to change currency
    When user changes current currency
    Then currency should be changed
    And End currency
