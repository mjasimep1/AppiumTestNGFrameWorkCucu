Feature: Cart scenarios
  Scenario Outline: Validate product info on cart page
    Given I'm logged in
    Then selected product should be listed in the cart when click add to cart btn "<selectedProductTitle>"
    Examples:
      |selectedProductTitle     | cartProductTitle  |
      |Sauce Labs Bolt T-Shirt  | Sauce Labs Bolt T-Shirt|
