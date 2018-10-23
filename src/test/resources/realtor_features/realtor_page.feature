Feature: realtor page

  Scenario: go to realtor page, choose realtor, check that photos on map match realtor photo
    Given open realtor.com
    When click find realtor button
    * enter realtor location "San Francisco, CA"
    * enter realtor name "Laura Lanzone"
    And click search button
    And click activity map button
    And click get started activity map button
    Then photos on map match realtor photo

  Scenario: go to realtor page, choose realtor, check that icon colors on map match house status
    Given open realtor.com
    When click find realtor button
    And enter realtor location "Boston, MA"
    And enter realtor name "Kristen Gaughan"
    And click search button
    And click activity map button
    And click get started activity map button
    And select first realtor card
    And click see agents nearby properties
    Then icon colors on map match house status

  Scenario: go to realtor page, choose realtor, check that icon become selected after click
    Given open realtor.com
    When click find realtor button
    And enter realtor location "Boston, MA"
    And enter realtor name "Kristen Gaughan"
    And click search button
    And click activity map button
    And click get started activity map button
    And select first realtor card
    Then icon become selected after click

  Scenario: go to realtor page, choose realtor, check that recommendations count on the page match recommendations count in the realtor's card
    Given open realtor.com
    When click find realtor button
    And enter realtor name "Adora Lazaro"
    And click search button
    And get recommendation count from realtor card
    And click on realtor icon
    And click load all recommendation
    Then recommendation count on the page match recommendations count in the realtor's card

  Scenario: go to realtor page, choose realtor, check that for sale houses on realtor page have status for sale
    Given open realtor.com
    When click find realtor button
    And enter realtor location "San Francisco, CA"
    And enter realtor name "Grace Lucero"
    And click search button
    And click on realtor icon
    Then houses with red icon have for sale status

  Scenario: go to realtor page, choose realtor, check that number of reviews on the page match reviews number in the realtor's card
    Given open realtor.com
    When click find realtor button
    And enter realtor name "Adora Lazaro"
    And click search button
    And get rating from realtor card
    And click on realtor icon
    And click load all reviews
    Then reviews count on the page match reviews count in the realtor's card

  Scenario: go to realtor page, choose realtor, check if every house on the iframe map has "Sold" status
    Given open realtor.com
    When click find realtor button
    And enter realtor name "Amanda Hurtt"
    And click search button
    And click activity map button
    And click get started activity map button
    Then photos on map match realtor photo

  Scenario: go to realtor page, choose realtor, check that realtors are displayed on page sorted by recommendations
    Given open realtor.com
    When click find realtor button
    And enter realtor location "San Francisco, CA"
    And get realtor sold houses count
    And choose recommendation
    And choose sort option
    Then realtors are displayed sorted by recommendation