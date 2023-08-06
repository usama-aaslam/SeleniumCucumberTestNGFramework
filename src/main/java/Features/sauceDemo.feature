Feature: Sauce Demo application Test
  @RegressionTests
  Scenario: Validate product added to cart successfully
    Given user open the browser
    Then user is on login page
    Then user logs into the application
    Then user validate the home page
    And user add products to cart
    Then validate product added to cart successfully


 @RegressionTests
  Scenario: Checkout from the cart
    Given user go to cart
    Then user enter checkout information
    Then user finish and checkout
    And validate user checkout successfully
    Then close browser

