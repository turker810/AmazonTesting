@us06
  Feature: Verify that user can choose products randomly and when added, price should be same with shopping cart
    Scenario: checking shopping cart price
    Given User navigates amazon webpage
    Then Choose products randomly
    And Get prices what is added
    Then Get prices in the shoppping cart
    And Verify that prices he got are same with shopping cart
