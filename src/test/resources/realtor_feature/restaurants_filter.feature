Feature: restaurants filter test, show restaurant on map

  Background:
    Given user go to realtor.com home page

  Scenario: [5231-school-rating]
    When the user enter city "San Francisco, CA" in search input
    And click search button
    And click view map button
    And click lifestyle button
    And click restaurants button
    Then is displayed restaurants