Feature: Registartion page

  Background: 
    Given open "chrome" browser
    When launch site

  @smoketest @realtest
  Scenario: registration page title test
    Then title should be contain "AidaForm"
    When close site

  @smoketest @realtest
  Scenario: registration page fields test
    Then page should be contain required fileds
    When close site
