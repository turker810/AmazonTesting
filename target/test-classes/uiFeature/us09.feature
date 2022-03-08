@us09
  Feature: Verify that user can make list in his shoppingList during shopping
           Also he can delete from his shoppingList
  Scenario:
  Given User navigates to wish list link "https://www.amazon.com/hz/wishlist/ls/34FZ5QIJK4JWK?ref_=wl_share"
  Then Clicks on wish list
  And verifies that items exist in the wish list
