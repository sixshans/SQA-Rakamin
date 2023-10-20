Feature: Add item to Cart

  @Regression @Positive @Cart
  Scenario: Add single item
    Given User on main page with item displayed
    And Click item Add to Cart button
    When Click Cart icon
    And User on cart page
    Then The item is listed in the Cart page

  @Regression @Positive @Cart
  Scenario: Add multiple item
    Given User on main page with item displayed
    And Click item Add to Cart button
    And Click second item Add to Cart
    And Click third item Add to Cart
    When Click Cart icon
    And User on cart page
    Then The items is listed in the Cart page

  @Regression @Negative @Cart
  Scenario: Remove item from the cart
    Given User on main page with item displayed
    And Click item Add to Cart button
    And Click second item Add to Cart
    When Click Cart icon
    And User on cart page
    When Click remove button
    Then The item was removed is not listed in the Cart page