@realtest
Feature: Registration for new user

  Scenario: Data table with out header
    Given open "chrome" browser
    When launch site
    And do successful registartion for given valid data
      | asdf,random-email,asdfgg |
      | asdg,random-email,asdfgj |
      | asdh,random-email,asdfgl |
    And close site
