Feature: Verify that user can choose products randomly and when added, price should be same with shopping cart
  Scenario: checking shopping cart price
    Given User navigates amazon webpage
    Then types any product
    And  adds second product and gets its price
    Then checks prices in the shoppping cart
    And Verify that both prices are same