Feature: Add new payee under pay bills

  Background:
    Given user is on the login page
    Then user clicks on 'Sign in' button
    Then user logs in as 'username'
    Then user navigates to 'Pay Bills' tab
    When user clicks on 'Add New Payee' button

  Scenario: Add a new payee
    Then creates a payee using the following information
      | Payee Name    | The Law Offices of Hyde, Price & Scharks |
      | Payee Address | 100 Same st, Anytown, USA, 10001         |
      | Account       | Checking                                 |
      | Payee details | XYZ account                              |
    Then message 'The new payee The Law Offices of Hyde, Price & Scharks was successfully created.' should be displayed