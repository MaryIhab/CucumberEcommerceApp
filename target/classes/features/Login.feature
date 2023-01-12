@App
Feature: user should be able to login to the system

  Background: user open browser and go to login page
    Given user navigates to login page

  Scenario: user login with valid username and password
    When user enter valid username and password And user click on login button
    Then user could login successfully and go to homepage
    And End browser