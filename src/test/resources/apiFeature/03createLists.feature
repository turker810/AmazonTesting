Feature: Trello_testi
  Scenario: Creating a list
   # Given user creates a board
    Then  from created board ,creates list name as "bugList1"
    Then  Assert status code for list is 200
    And   verifies list is created as "bugList1"

    Scenario: updateList
      Given PUT request for update list
      Then verify update response

