Feature: Navigating to specific accounts in Accounts Activity

  Background:
    Given user is on the login page
    Then user clicks on 'Sign in' button
    Then user logs in as 'username'


  Scenario Outline: <Type> account redirect
    When user clicks on '<Link>' link on the Account Summary Page
    Then user verifies that the page title is 'Zero - Account Activity'
    And Account drop drown should have '<Option>' selected

    Examples: Data
      | Type        | Link        | Option      |
      | Savings     | Savings     | Savings     |
      | Brokerage   | Brokerage   | Brokerage   |
      | Checking    | Checking    | Checking    |
      | Credit Card | Credit Card | Credit Card |
      | Loan        | Loan        | Loan        |