Feature: Product scenarios
  Scenario Outline: Validate product info on Products page
    Given I'm logged in
    Then the product is listed with title "<title>" and price "<price>"
    Examples:
    |title                    | price  |
    |Sauce Labs Bolt T-Shirt  | $15.99 |

  Scenario Outline: Validate product info on Product Details page
    Given I'm logged in
    When I click product title "<title>"
    Then I should be on product details page with title "<title>", price "<price>" and description "<description>"
    Examples:
      | title                   | price  | description |
      | Sauce Labs Backpack     | $29.99 | carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection. |

  Scenario Outline: Validate filter button on Home page
    Given I'm logged in
    When I click filter button
    Then I should be on filter details popup with title "<filterTitle>"
    Examples:
      |filterTitle        |
      | Sort items by...  |

  Scenario Outline: Validate product info on Products page with test failed login
    Given I'm logged in with problem user
    Then the product is listed with title "<title>" and price "<price>"
    Examples:
      |title                    | price  |
      |Sauce Labs Bolt T-Shirt  | $15.99 |

  Scenario Outline: Validate product info on Product Details page
    Given I'm logged in with problem user
    When I click product title "<title>"
    Then I should be on product details page with title "<title>", price "<price>" and description "<description>"
    Examples:
      | title                   | price  | description |
      | Sauce Labs Backpack     | $29.99 | carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection. |
