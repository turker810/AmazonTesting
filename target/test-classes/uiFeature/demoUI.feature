@demoend2end
  Feature: Go to Amazon checking shopping and adding cart system from choosing item to removing item
    Scenario: Checking amazon webpage while shopping
      Given user goes to Amazon WebPage "https://www.amazon.com/"
      Then clicks on ALL menu and clicks "Fire Tablets"
      Then selects tablets such as "Fire 7"
      And gets the price and clicks on add To Cart
      Then verifies item is added to cart
      Then gets the price in the cart
      And verifies prices are same
      Then user goes back to the card
      And delete added item
      And verifies item is deleted
      Given User navigates to wish list link "https://www.amazon.com/hz/wishlist/ls/34FZ5QIJK4JWK?ref_=wl_share"
      Then Clicks on wish list
      And verifies that items exist in the wish list
      Given User navigates homepage
      Then Scrolls down in homepage,
      Then Clicks on any links
      And Verifies that links works correctly






