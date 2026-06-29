Feature:
  Scenario: admin deactivates an account

    Given admin is logged into the application
    And admin is on the accounts tab
    When admin clicks deactivate button for account number "MAZE23173017"
    Then account is deactivated

  Scenario: admin activates an account

    Given admin is logged into the application
    And admin is on the accounts tab
    When admin clicks activate button for account number "MAZE23173017"
    Then account is activated