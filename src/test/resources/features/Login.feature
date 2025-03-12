@mobile @regression
Feature: Login Functionality
  As a user
  I want to login to the application
  So that I can access my account

  @smoke @login
  Scenario: Test app open
    Given I am on the login screen


  @smoke @test
  Scenario: Test the click on App 
    Given I am on the login screen
    When I click on the App button
      


