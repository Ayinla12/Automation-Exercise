@registerOrder @autoExe
Feature: User account creation, product purchase, and account creation

  Scenario: Successfully create an account, place an order, and delete the account
    Given the user accesses the automation exercise home page
    When the user clicks the signup-login button
    And the user fills all the required details to create an account
    And the user verifies ACCOUNT CREATED is displayed
    And the user clicks on the continue button
    And the user verifies logged in as username is displayed at the top
    And the user adds products to the cart
    And the user clicks the cart button
    And the user verifies the cart page is displayed
    And the user clicks Proceed to Checkout
    And the user verifies Address Details and Review Your Order are displayed
    And the user enters a description in the comment text area
    And the user clicks the Place Order button
    And the user enters payment details including Name on Card, Card Number, CVC, and Expiration Date
    And the user clicks the Pay and Confirm Order button
    Then the user verifies the success message 'Congratulations! Your order has been confirmed!'
    And the user clicks the Delete Account button
    And the user verifies ACCOUNT DELETED is displayed
    And the user clicks the Continue button
