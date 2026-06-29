Feature:
  Scenario: User transfers to active account
    Given user is on the transactions page
    And user is on transfer tab
    And user waits for account number to be visible
    When user enters the other account number "MAZE29817855"
    And user enters the amount "1000"
    And user clicks transfer
    Then user gets success alert

  Scenario: User transfers to a inactive account
    Given user is on the transactions page
    And user is on transfer tab
    And user waits for account number to be visible
    When user enters the other account number "MAZE55019680"
    And user enters the amount "1000"
    And user clicks transfer
    Then user gets failure alert

