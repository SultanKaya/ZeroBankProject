Feature: Account Activities

  Background:
    Given user is on the login page
    Then user clicks on 'Sign in' button
    Then user logs in as 'username'
    Then user navigates to 'Account Activity' tab

  Scenario: Page Title
    Then user verifies that the page title is 'Zero - Account Activity'


  Scenario: Default drop down option
    Then user verifies that the default drop down option is 'Savings'


  Scenario: Account Activity Dropdown
    Then user verifies that the following 'Account' dropdown options are available
      | Savings     |
      | Checking    |
      | Savings     |
      | Loan        |
      | Credit Card |
      | Brokerage   |


  Scenario: Transactions Table headers
    Then user verifies that 'Transactions Table' following table columns are displayed
      | Date        |
      | Description |
      | Deposit     |
      | Withdrawal  |