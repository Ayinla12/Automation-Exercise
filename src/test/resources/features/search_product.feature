@searchProduct  @autoExe

Feature: Search for a product on Automation Exercise

  Scenario: User searches for a product
    Given I access the Automation Exercise home page
    When I click on the products button
    And I enter the product name "Tshirt" in the search input field
    And I click on the search button
    Then I should be presented with the searched products section
    And all the products related to the search should be visible