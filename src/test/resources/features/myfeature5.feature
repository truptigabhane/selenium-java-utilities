@realtest
Feature: Registration with valid and invalid data for happy path and fuzzy test

  Scenario Outline: registratio page functional testing 
    Given open "chrome" browser
    When launch site
    And fill username with "<un>" data
    And fill email with "<em>" data
    And fill password with "<pwd>" data
    And fill confirm password with "<cpwd>" data
    And select terms checkbox
    And click on button
    Then related msg should be displayed as per "<criteria>"
    When close site
    And clear data in DB

    Examples: 
      | un   | em                   | pwd    | cpwd   | criteria       |
      | asdf | random-email         | asdfgh | asdfgh | all_valid      |
      | azqw | random-email         | asd@gh | asd@gh | all_valid      |
      | zasw | random-email         | asd123 | asd123 | all_valid      |
      |      | random-email         | asdfgh | asdfgh | un_blank       |
      | asdf |                      | asdfgh | asdfgh | em_blank       |
      | asdf | random-email         |        | asdfgh | pwd_blank      |
      | asdf | random-email         | asdfgh |        | cpwd_blank     |
      | asdf | magnitiait@gmail.com | asdfgh | asdfgh | em_alreadyused |
      | asdf | magnitiait           | asdfgh | asdfgh | em_wrongformat |
      | asdf | random-email         | asd    | asd    | pwd_wrongsize  |
      | asdf | random-email         | asdfgh | xyzwer | cpwd_wrong     |
