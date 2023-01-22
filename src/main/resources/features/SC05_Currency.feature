@App
Feature: user should be able to change currency

  Scenario: user changes currency
    When user changes current currency
    Then currency should be changed
