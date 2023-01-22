@App
Feature: user should be able to register to the system

  Scenario: user register with valid info
    When user enters all data successfully and submits
    Then success registration message should be displayed to the user
