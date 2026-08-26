Feature: Registration for new user

  Scenario Outline: happy path data driven test using multiple valid data
    Given open "chrome" browser
    When launch site
    And fill fields with "<valid>" data 
    #use same value for password and confirm password
    And select terms checkbox
    And click on button
    Then "Let's Confirm Your Email!" msg should be displayed
    When close site

    @smoketest
    Examples: 
      | valid                       |
      | kalam,random-email,abdul123 |

    @realtest
    Examples: 
      | valid                          |
      | abdil,random-email,kalam@2     |
      | virat,random-email,anushka@143 |
