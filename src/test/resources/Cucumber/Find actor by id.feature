//@ignore
Feature: Add a new actor

  Scenario: I successfully get an actor from table by id
    Given I have actor id
    When I use get url using correct id
    Then I get the correct actor information