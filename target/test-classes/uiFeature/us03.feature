@us03
  Feature:Verify that when user clicks on ALL section, he/she can choose/see all elements in ALL section
    Scenario: User verifies how elements are selected in  ALL menu
    When User navigates to homepage
    And User clicks on ALL section
   # Then Verify that all elements are seen
    And User chooses one of them such as "Electronics"
    Then user verifies that there are 12 subcategories
    And user verifies the title of all subcategories

