Feature: Find Transaction in Account Activity

  Background:
    Given user is on the login page
    Then user clicks on 'Sign in' button
    Then user logs in as 'username'
    Then user navigates to 'Account Activity' tab
    When user clicks on 'Find Transaction' button

  Scenario: Search date range
    When user enters date range from '2012-09-01' to '2012-09-06'
    And user clicks on 'transaction find' button
    Then results table should only show transactions from '2012-09-01' to '2012-09-06'
    And the results should be sorted by date
    When user enters date range from '2012-09-02' to '2012-09-06'
    And user clicks on 'transaction find' button
    Then results table should only show transactions from '2012-09-02' to '2012-09-06'
    And the results table should not contain transactions date '2012-09-01'


  Scenario: Search description
    Then user enter description 'ONLINE'
    And user clicks on 'transaction find' button
    Then results table should show descriptions containing 'ONLINE'
    When user enter description 'OFFICE'
    And user clicks on 'transaction find' button
    Then results table should show descriptions containing 'OFFICE'
    And the results table should not show description containing 'ONLINE'

  @Bug_Found #Case insensitivity does not work. Scenario is invalid
  Scenario: Search description case insensitive
    Then user enter description 'ONLINE'
    And user clicks on 'transaction find' button
    Then results table should show descriptions containing 'ONLINE'
    When user enter description 'online'
    And user clicks on 'transaction find' button
    Then results table should show descriptions containing 'ONLINE'



  Scenario: Type
    And user clicks on 'transaction find' button
    Then results table should show at least one result under 'Deposit'
    Then results table should show at least one result under 'Withdrawal'
    When user selects type 'Deposit'
    And user clicks on 'transaction find' button
    Then results table should show at least one result under 'Deposit'
    But the results table should show no result under 'Withdrawal'
    When user selects type 'Withdrawal'
    And user clicks on 'transaction find' button
    Then results table should show at least one result under 'Withdrawal'
    But the results table should show no result under 'Deposit'

