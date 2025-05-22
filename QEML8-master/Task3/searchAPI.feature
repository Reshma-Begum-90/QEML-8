Feature: Search API functionality

  Scenario Outline: Search for a product using API
    Given the search query is "<product>"
    When I send a GET request to /search endpoint
    Then the response should contain "<product>"

    Examples:
      | product |
      | Laptop  |
      | Mobile  |
      | Tablet  |
