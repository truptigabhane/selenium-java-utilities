Feature: manipulations

  Scenario Outline: add two numbers
    Given take <i1> and <i2>
    When do addition
    Then display addition output

    Examples: 
      | i1  | i2  |
      |  23 |  90 |
      | -67 | -90 |
      |   0 |  45 |
