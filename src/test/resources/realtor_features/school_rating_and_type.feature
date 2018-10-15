Feature: school rating and type test, select schools with entered rating and type

  Background:
    Given user go to realtor.com home page

  Scenario: [5231-school-rating]
    When the user enter city to search input
    And click search button
    And click view map button
    And click school button
    And select high school
    And select school rating "8"
    Then is school rating match "8"
    And is school type match high