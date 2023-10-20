Feature: Login page Swag Labs

  @Regression @Positive @Login
  Scenario: Login Success
    Given Login page Swag Labs
    When Input username
    And Input password
    And Click login button
    Then User on main page

  @Regression @Negative @Login
  Scenario: Login Failed
    Given Login page Swag Labs
    When Input username
    And Input invalid password
    And Click login button
    Then User get error message