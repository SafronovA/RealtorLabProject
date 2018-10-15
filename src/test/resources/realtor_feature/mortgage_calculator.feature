Feature: mortgage calculator test, calculate monthly payment

  Background:
    Given user go to realtor.com home page

  Scenario: [5231-school-rating]
    When the user navigate cursor to mortgage link
    And click mortgage calculator link
    And select loan type "15-Year Fixed"
    And set rate "6"
    And set home price "110000"
    And set down payment "10000"
    Then is displayed price correct