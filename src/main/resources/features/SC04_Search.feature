@App
Feature: user should be able to search

  Scenario: user search
    When user type in the search field
    Then results should be displayed based on the search criteria
