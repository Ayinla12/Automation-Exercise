@cartQuantity  @autoExe
Feature: Verification of product quantity in cart

  Scenario: Successfully verify product quantity in cart
    Given the user accesses the Automation exercise home page
    And verifies the home page is displayed
    When the user clicks View Product for any product on the home page
    And verifies the product details page is opened
    And increases the quantity to 4
    Then the user clicks the Add to Cart button
    And user clicks on the view cart button
    And verifies that the product is displayed in the cart page with the exact quantity