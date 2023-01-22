@App
Feature: user should be able to add item to wishlist

  Scenario: user compares between items
    When user adds items to compare
    Then item should be added to the compare
