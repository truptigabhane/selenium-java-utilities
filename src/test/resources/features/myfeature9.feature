@realtest
Feature: Registration for new user

  Scenario: 
    Given open "chrome" browser
    When launch site
    And do registartion by taking test data from text file
    And close site

  Scenario: 
    Given open "chrome" browser
    When launch site
    And do registartion by taking test data from excel file
    And close site

  Scenario: DB test
    Given open "chrome" browser
    When launch site
    And do registartion by taking test data from DB
    And close site
