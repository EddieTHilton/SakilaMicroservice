Feature: Add a new film

  #I want to be able to save a film to the database for retrieval later.

  Scenario: I successfully add a film to the table
    Given I have film title, description, release year, rental rate, length, replacement cost, rating and special features.
    When Title equals "Test Movie"
    And Description equals "Descriptive description."
    And Release year equals 9099
    And Rental rate equals 01.01
    And Length equals 1
    And Replacement cost equals 01.01
    And Rating cost equals "?"
    And Special features cost equals "Features"
    Then Film "Test Movie" will be added to database

