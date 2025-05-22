Feature: Product Search

  Scenario Outline: Search for products
    Given I launch the "<browser>" browser
    When I search for "<product>"
    Then I should see results for "<product>"

    Examples:
      | browser  | product |
      | chrome   | Laptop  |
      | firefox  | Mobile  |
