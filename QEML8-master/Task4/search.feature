Feature: Cloud Grid Search Test

  Scenario Outline: Search for product on cloud browsers
    Given I launch the "<browser>" browser on cloud
    When I search for "<product>"
    Then I should see results related to "<product>"

    Examples:
      | browser | product |
      | chrome  | Laptop  |
      | safari  | Phone   |
