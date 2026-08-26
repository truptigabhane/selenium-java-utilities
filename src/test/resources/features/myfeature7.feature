@realtest
Feature: Registration for new user

  Scenario: Data table with heders
    Given open "chrome" browser
    When launch site
    And do successful registartion by giving valid data
      | un   | email        | pwd    |
      | asdf | random-email | asdfgg |
      | asdg | random-email | asdfgj |
      | asdh | random-email | asdfgl |
    And close site
