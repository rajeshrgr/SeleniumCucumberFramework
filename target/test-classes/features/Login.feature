@Login
Feature: Login feature
  User cover all test cases of login feature

@LoginWithValidCredientials
Scenario: Login with valid credentials
    Given I open the browser
    When I enter username "rajesh.rgr28@gmail.com" and password "Rachana.78"
    And I click on login button
    Then I should see the dashboard
