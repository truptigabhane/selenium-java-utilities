@smoketest @realtest
Feature: Registration for new user

  Scenario: Happy path test using valid data
    Given open "chrome" browser
    When launch site
    And do successful registartion by using
      """
         asdf,
         random-email,
         asdfgh   #use same value for password and confirm password
      """
    And close site
