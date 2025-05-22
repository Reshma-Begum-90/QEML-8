Feature: Search functionality

  Scenario Outline: Search for a product
    Given I launch the "<browser>" browser
    When I search for "<product>"
    Then I should see results for "<product>"

    Examples:
      | browser  | product |
      | chrome   | Laptop  |
      | firefox  | Phone   |
      | edge     | Tablet  |
