Feature: Login Feature
  User should be able to login with valid credentials only

  Background:
    Given user is on the login page
    Then user clicks on 'Sign in' button

  Scenario: Authorized user login
    And user logs in as 'username'
    Then user verifies that the page title is 'Zero - Account Summary'


  Scenario: Unauthorized username
    And user enters username 'WRONG-username' and password 'password'
    Then user verifies that the error message 'Login and/or password are wrong.' is displayed

  Scenario: Unauthorized password
    And user enters username 'username' and password 'WRONG_password'
    Then user verifies that the error message 'Login and/or password are wrong.' is displayed

  Scenario: Empty Credentials
    And user enters username ' ' and password ''
    Then user verifies that the error message 'Login and/or password are wrong.' is displayed