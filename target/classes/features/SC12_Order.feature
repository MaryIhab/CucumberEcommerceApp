@App
Feature: user submits an order

  Scenario: user place an order successfully
    When user adds items to cart and place order
    Then order should be created successfully
