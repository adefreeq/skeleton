Feature: API Testing

  @demo
  Scenario: Verify user list
    When I send a GET request to the API endpoint /api/users?page=2
    Then the response status code should be 200
    Then the response should contain the following user ids: 7, 8, 9, 10, 11, 12


  Scenario: Verify successful user creation
    When I send a POST request to the API endpoint /api/users with body:
      | name     | job    |
      | morpheus | leader |
    Then the response status code should be 201
    Then the response should contain name morpheus and job leader



