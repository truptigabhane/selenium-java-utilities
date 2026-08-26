Feature: manipulations

  Scenario Outline: reverse a string
    Given take "<name>"
    When do reverse
    Then display reverse output

    Examples: 
      | name       |
      | magnitia   |
      | madam      |
      | abdulkalam |
      | malayalam  |
