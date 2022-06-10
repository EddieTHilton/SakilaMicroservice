Feature: Add a new actor

  Scenario: I successfully add an actor to the table
    Given I have actor information, and an actor table exists
    When I post actor information
    Then I get the success return string

  Scenario: I dont have enough info
    Given I have an actor's first name
    And I don't have their last name
    When I try to add them into their database
    Then I get an error message