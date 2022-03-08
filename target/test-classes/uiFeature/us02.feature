@us02
  Feature: Verify if a user will not be able to sign in with a invalid username and invalid password.
    Scenario: User will not be able to sign in with invalid credentials
    Given User navigates to "https://www.amazon.com/"
    Then User clicks on sign in button
    Then User types invalid credentials
    When User clicks on submit button
    And User verifies that user can not sign in