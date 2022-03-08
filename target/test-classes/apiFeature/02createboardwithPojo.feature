@pojo
Feature:
  Scenario: use pojo to create board
    Given post request for creating board "yeni" with pojo
    Then  get response using pojo
    And assert response "yeni"