@addToCart  @autoExe

Feature: Add products to the cart

  Scenario: Successfully add two products to cart and verify the details
    Given the user accesses the Automation Exercise home page
    When the user clicks on the products button
    And the user hovers over the first product and clicks Add to cart
    And the user clicks on the continue shopping button
    And the user hovers over the second product and clicks Add to cart
    And the user clicks on the view cart button
    Then both products should be visible in the cart
    And the prices, quantities, and total price of the products should be correct