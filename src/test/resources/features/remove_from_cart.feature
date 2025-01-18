@removeProduct   @autoExe
Feature: Remove product from cart

  Scenario: User removes a product from the cart successfully
    Given user accesses the automation exercise home page
    And verifies the home page is visible successfully
    When user adds products to the cart
    And clicks on the view cart button
    Then verifies that the cart page is displayed
    And clicks on the X button corresponding to a particular product
    And verifies that the product is removed from the cart