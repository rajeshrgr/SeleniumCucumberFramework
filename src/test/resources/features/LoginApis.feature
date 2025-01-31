@LoginAPI
Feature: User Login API

@Login_api
Scenario: Validate successful user login API response
    Given API endpoint is "https://reqres.in/api/login"
    When User sends a POST request with valid credentials
    Then API response status code should be 200
    And API response should contain token