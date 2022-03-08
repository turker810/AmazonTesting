@us07
  Feature: user pages down in homepage, the links should work correctly.Verify one link brings user to the correct place.

  Scenario: checking links in the home page down
  Given User navigates homepage
  Then Scrolls down in homepage,
  Then Clicks on any links
  And Verifies that links works correctly