Feature: Registration for wrong user

  Background: 
    Given open "chrome" browser
    When launch site

  Scenario Outline: Error handling test or fuzzing test for wrong data in registration form
    And fill fields with "<un>" ,"<em>" ,"<pwd>" and "<cpwd>" data
    And select terms checkbox
    And click on button
    Then related error msg should be displayed as per "<criteria>"
    When close site

    Examples: 
      | un   | em                   | pwd    | cpwd   | criteria            |
      |      | random-email         | asdfgh | asdfgh | un_blank            |
      | asdf |                      | asdfgh | asdfgh | em_blank            |
      | asdf | random-email         |        | asdfgh | pwd_blank           |
      | asdf | random-email         | asdfgh |        | cpwd_blank          |
      | asdf | magnitiait@gmail.com | asdfgh | asdfgh | em_duplicate        |
      | asdf | magnitiait           | asdfgh | asdfgh | em_wrongemailformat |
      | asdf | random-email         | asd    | asd    | pwd_wrongpwdsize    |
      | asdf | random-email         | asdfgh | xyzwer | cpwd_wrong          |
 
 Scenario: abc test
 When close site 
