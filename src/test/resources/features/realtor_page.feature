Feature: realtor page

  Scenario: icon colors on map match house status
    When click find realtor button
    And enter realtor location "Boston, MA"
    And enter realtor name "Kristen Gaughan"
    And click search button
    And click activity map button
    And click get started activity map button
    And select first realtor card
    And click see agents nearby properties
    Then icon colors on map match house status

  Scenario: icon become selected after click
    When click find realtor button
    And enter realtor location "Boston, MA"
    And enter realtor name "Kristen Gaughan"
    And click search button
    And click activity map button
    And click get started activity map button
    And select first realtor card
    Then icon become selected after click

  Scenario: for sale houses on realtor page have status for sale
    When click find realtor button
    And enter realtor location "San Francisco, CA"
    And enter realtor name "Grace Lucero"
    And click search button
    And click on realtor icon
    Then houses with red icon have for sale status

  Scenario: photos on map match realtor photo
    When click find realtor button
    And enter realtor location "San Francisco, CA"
    And enter realtor name "Laura Lanzone"
    And click search button
    And click activity map button
    And click get started activity map button
    Then photos on map match realtor photo

  Scenario: recommendations count on the page match recommendations count in the realtor's card
    When click find realtor button
    And enter realtor name "Adora Lazaro"
    And click search button
    And get recommendation count
    And click on realtor icon
    And click load all recommendation
    Then recommendation count on the page match recommendations count in the realtor's card

  Scenario: number of reviews on the page match reviews number in the realtor's card
    When click find realtor button
    And enter realtor name "Adora Lazaro"
    And click search button
    And get rating count
    And click on realtor icon
    And click load all reviews
    Then reviews count on the page match reviews count in the realtor's card

  Scenario: every house on the iframe map has "Sold" status
    When click find realtor button
    And enter realtor name "Amanda Hurtt"
    And click search button
    And get realtor sold houses count
    And click on realtor icon
    And scroll to map, click realtor sold houses, double zoom out
    Then sold houses count in the realtor card match count on the iframe map
    And houses on the iframe map have sold status

  Scenario: realtors are displayed on page sorted by recommendations
    When click find realtor button
    And enter realtor location "San Francisco, CA"
    And get realtor sold houses count
    And choose recommendation
    And choose sort option
    Then realtors are displayed sorted by recommendation
