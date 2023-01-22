@App
Feature: user should be able to add to cart

  Scenario: user selects an item to be added to the cart
    Given user logged in to home page to add to cart
    When user adds an item to the cart
    Then item should be added to the cart
    And End cart
