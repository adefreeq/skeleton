@regression
Feature: Feature Sets Dashboard

Feature: Login to SauceDemo application

  Background: Login to application
    Given the user navigates to the login page
    When the user enters username "standard_user" and password "secret_sauce"
    And clicks the login button
    Then the user should be redirected to the inventory page

  Scenario: Successful login with standard user
    Then the user should be redirected to the inventory page
