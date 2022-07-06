#Feature: Add an actor with special characters in name
  Scenario Outline: Add an actor with special chracters to the table
    Given I have actor special character first name, last name
    When Special first name equals "<first_name>"
    And Special last name equals "<last_name>"
    Then Special Actor "<first_name>" "<last_name>" will be added to database

    Examples:
      | first_name    | last_name       |
      | lower         | case            |
      | UPPER         | CASE            |
      | MiXed         | CaSe            |
      | 123           | 456             |
      | Alpha123      | Numeric456      |
      | punctuat!on,  | /punctuation?   |
      | email@url.com | www.website.com |
      | (paren)       | (thesis)        |
      | {curly}       | {brackets}      |
      | (1 + 10)      | 20 - 5          |