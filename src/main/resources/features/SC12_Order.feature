@App
Feature: user submits an order

  Scenario: user place an order successfully
    Given user logged in to home page to place an order
    When user adds items to cart and place order
    Then order should be created successfully
    And End Order
