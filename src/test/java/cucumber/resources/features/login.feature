Feature: Login page Sauce Demo
  Scenario: Success Login
    Given Halaman login sauce demo
    When Input username
    And Input password
    And Click login button
    Then user in dashboard page

  Scenario: Failed login
    Given Halaman login sauce demo
    When Input username
    And Input invalid password
    And Click login button
    Then User get Error message

