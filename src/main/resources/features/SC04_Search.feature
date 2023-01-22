@App
Feature: user should be able to search

  Scenario: user search
    Given user logged in to home page
    When user type in the search field
    Then results should be displayed based on the search criteria
    And End