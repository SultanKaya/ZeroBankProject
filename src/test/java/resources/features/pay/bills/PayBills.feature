

Feature: Pay Bills

  Background:
    Given user is on the login page
    Then user clicks on 'Sign in' button
    Then user logs in as 'username'
    Then user navigates to 'Pay Bills' tab

  Scenario: Page Title
    Then user verifies that the page title is 'Zero - Pay Bills'

  Scenario: Pay Operation happy path
    Then user enters payment amount of '100.0'
    And user enters date of '2020-1-27'
    And user clicks on 'Pay' button
    Then user verifies that the success message is displayed 'The payment was successfully submitted.'

  Scenario Outline: Pay Operation negative path
    Then user enters payment amount of '<Amount>'
    And user enters date of '<Date>'
    And user clicks on 'Pay' button
    Then user verifies that the error message 'Please fill out this field.' is displayed on 'Pay Bills' page

    Examples: Data
      | Amount | Date      |
      | null   | 2020-1-20 |
      | 100    | null      |

  @BUG
  Scenario Outline: Pay Operation wrong entries
    Then user enters payment amount of '<Amount>'
    And user enters date of '<Date>'
    Then user verifies that 'date' input box is empty
    Then user verifies that 'amount' input box is empty

    Examples:
      | Amount  | Date    |
      | letters | letters |
      | !@#$%   | @#$$%^  |