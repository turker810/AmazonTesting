@us04
Feature: Enter a valid product name and click on the search icon.It should show the result with the given product name.

  Scenario: checking search icon results
    Given User navigates to homepage
    Given Types anything on search box
    Then Clicks on search button
    And Verify that the results starts with what user types
@us04tc2

    Scenario: The same word enters multiple times, it should load results with a product containing the given text.
    Given User navigates to homepage
    Then Types sameword multiple times on search box
    Then Clicks on search button
    And Verify that the results starts with containing the given text

