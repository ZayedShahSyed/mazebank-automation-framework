Feature: User Logs into the application
  Background:
    Given user is on the login page

  Scenario Outline: user enters valid credentials
    When user enters email "<email>" and password "<password>"
    And user clicks login button
    Then user handles alert
    And user logs into the dashboard

    Examples:
      | email            | password     |
      | lala@gmail.com   | Password@123 |
      | vikash@gmail.com | Password@123 |

