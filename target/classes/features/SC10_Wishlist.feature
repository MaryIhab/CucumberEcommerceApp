@App
Feature: user should be able to add item to wishlist

  Scenario: user adds item to wishlist
    When user adds an item to the wishlist
    Then item should be added to the wishlist
