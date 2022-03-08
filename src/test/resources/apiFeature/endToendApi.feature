@api1
Feature: Trello api crud operations for board
  Scenario: create_board
    Given Send POST request for create "a" board
    Then  Assert status code 200
    And Assert board name is "a"

    @api2
    Scenario: get_board(read)
      Then read the created board
      And assert board is existed

  @api3
      Scenario: update_board
        Then update the created board name
        And assert board name is updated

  @api3
  Scenario: delete_board
    Then delete the created board
    And assert board name is deleted
