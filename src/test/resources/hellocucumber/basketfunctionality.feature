Feature: basket functionality: add, remove, increase quantity
  Scenario: Add to basket via "Buy now" button
    Given I login as non registered user on haircarepanda
    And I select category "gummies"
    And I put cursor on product
    When I tap on Buy now button
    Then the basket page is displayed with selected previously product

  Scenario: Remove product from basket
    Given I login as non registered user on haircarepanda
    And I add product "gummies" to basket
    And I navigate to basket
    When I tap on delete icon near product name
    Then the message Your shopping cart is empty An empty basket is a sad basket is displayed

  Scenario: Increase quantity of product in basket
    Given I login as non registered user on haircarepanda
    And I add product "gummies" to basket
    And I navigate to basket
    When I tap on + icon near product name
    Then the quantity of products is increased
    Then the price is calculated correctly

