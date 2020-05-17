

Feature: Purchase Foreign Currency

  Background:
    Given user is on the login page
    Then user clicks on 'Sign in' button
    Then user logs in as 'username'
    Then user navigates to 'Pay Bills' tab
    When user clicks on 'Purchase Foreign Currency' button


  Scenario: Available Currencies
    Then following currencies should be available
      | Australia (dollar)     |
      | Canada (dollar)       |
      | Switzerland (franc)   |
      | China (yuan)          |
      | Denmark (krone)       |
      | Eurozone (euro)       |
      | Great Britain (pound) |
      | Japan (yen)           |
      | Mexico (peso)         |
      | Norway (krone)        |
      | New Zealand (dollar)  |
      | Singapore (dollar)    |



  Scenario: Error message for not selecting currency
    When user tries to calculate cost without selecting a currency
    Then error message is displayed 'Please, ensure that you have filled all the required fields with valid values.'


  Scenario: Error message for not entering value
    When user tries to calculate cost without entering a value
    Then error message is displayed 'Please, ensure that you have filled all the required fields with valid values.'