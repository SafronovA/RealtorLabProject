Feature: school rating and type test, select schools with entered rating and type

  Background:
    Given user go to realtor.com home page

  Scenario: [5231-school-rating]
    When the user enter city to search input
    And click search button
    And click view map button
    And click school button