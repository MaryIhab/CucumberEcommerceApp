@App
Feature: user should be able to register to the system

  Scenario: user register with valid info
    Given user navigates to registration  page
    When user enters all data successfully and submits
    Then success registration message should be displayed to the user
    And Close browser
