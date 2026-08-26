@realtest
Feature: Registration for new user

  Scenario Outline: Data table data along with examples data
    Given open "<bn>" browser
    When launch site
    And do successful registartion by giving valid data in "<bn>"
      | un   | email        | pwd    |
      | asdf | random-email | asdfgg |
      | asdg | random-email | asdfgj |
      | asdh | random-email | asdfgl |
    And close site

    Examples: 
      | bn      |
      | chrome  |
      | firefox |
      | edge    |
