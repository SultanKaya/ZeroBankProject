Feature: Account Summary

  Background:
    Given user is on the login page
    Then user clicks on 'Sign in' button
    Then user logs in as 'username'
    Then user navigates to 'Account Summary' tab

  Scenario: Page Title
    Then user verifies that the page title is 'Zero - Account Summary'


  Scenario: Account Types
    Then user verifies that the following account types are displayed
      | Cash Accounts       |
      | Investment Accounts |
      | Credit Accounts     |
      | Loan Accounts       |

  Scenario: Credit Accounts table
    Then user verifies that 'Credit Accounts' following table columns are displayed
      | Account     |
      | Credit Card |
      | Balance     |