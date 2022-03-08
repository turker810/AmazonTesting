@us05
  Feature: Verify that user can filter search results and can use any of filters such as price,color
    Scenario: filtering search result
    Given User navigates to homepage
    Then Types  on search box
    And  Clicks on search button
    Then Choose any filter option
    And Verify that prices are matched
