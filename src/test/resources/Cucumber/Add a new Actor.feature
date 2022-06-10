Feature: Add a new actor

  Scenario: I successfully add an actor to the table
    Given I have actor first name, last name
    When First name equals "test"
    And Last name equals "testerson"
    Then Actor "test" "testerson" will be added to database

