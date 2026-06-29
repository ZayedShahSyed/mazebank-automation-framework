Feature:
  Scenario:
    Given user is logged in with email "lala@gmail.com" and password "Password@123"
    When user logs out of his account
    Then user is logged out