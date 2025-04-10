Feature: API Testing

  @demo
  Scenario: Verify GET request to users endpoint
    Given the API endpoint /api/users?page=2
    When I send a GET request
    Then the response status code should be 200


