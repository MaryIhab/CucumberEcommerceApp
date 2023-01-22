@App
Feature: user should be able to add item to wishlist

  Scenario: user compares between items
    Given user logged in to home page to compare between items
    When user adds items to compare
    Then item should be added to the compare
    And End compare
