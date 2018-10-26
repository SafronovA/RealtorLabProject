Feature: realtor page

  @CheckIconsColor
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

  @ClickOnIcon
  Scenario: icon become selected after click
    When click find realtor button
    And enter realtor location "Boston, MA"
    And enter realtor name "Kristen Gaughan"
    And click search button
    And click activity map button
    And click get started activity map button
    And select first realtor card
    Then icon become selected after click

  @ForSaleRealtorHouses
  Scenario: for sale houses on realtor page have status for sale
    When click find realtor button
    And enter realtor location "San Francisco, CA"
    And enter realtor name "Grace Lucero"
    And click search button
    And click on realtor icon
    Then houses with red icon have for sale status

  @PhotosOnMap
  Scenario: photos on map match realtor photo
    When click find realtor button
    And enter realtor location "San Francisco, CA"
    And enter realtor name "Laura Lanzone"
    And click search button
    And click activity map button
    And click get started activity map button
    Then photos on map match realtor photo

  @RealtorRecommendations
  Scenario: recommendations count on the page match recommendations count in the realtor's card
    When click find realtor button
    And enter realtor name "Adora Lazaro"
    And click search button
    And get recommendation count
    And click on realtor icon
    And click load all recommendation
    Then recommendation count on the page match recommendations count in the realtor's card

  @RealtorReviews
  Scenario: number of reviews on the page match reviews number in the realtor's card
    When click find realtor button
    And enter realtor name "Adora Lazaro"
    And click search button
    And get rating count
    And click on realtor icon
    And click load all reviews
    Then reviews count on the page match reviews count in the realtor's card

  @RealtorSoldHouses
  Scenario: every house on the iframe map has "Sold" status
    When click find realtor button
    And enter realtor name "Amanda Hurtt"
    And click search button
    And get realtor sold houses count
    And click on realtor icon
    And scroll to map, click realtor sold houses, double zoom out
    Then sold houses count in the realtor card match count on the iframe map
    And houses on the iframe map have sold status

  @SortByRecommendations
  Scenario: realtors are displayed on page sorted by recommendations
    When click find realtor button
    And enter realtor location "San Francisco, CA"
    And click search button
    And choose recommendation amount: "10+"
    And choose sort option: "Most Recommendations"
    Then realtors are displayed sorted by recommendation

  @MortgageCalculator
  Scenario Outline: check that calculated and displayed price is correct
    When move to mortgage calculator page
    And  select loan type as "<LOAN_TYPE>"
    And  select rate as "<RATE>"
    And  select home price as "<HOME_PRICE>"
    And  select down payment as "<DOWN_PAYMENT>"
    Then check that price calculated correctly with loan type = "<LOAN_TYPE>", rate = "<RATE>", home price = "<HOME_PRICE>", down payment = "<DOWN_PAYMENT>"

    Examples:
      | LOAN_TYPE     | RATE | HOME_PRICE | DOWN_PAYMENT |
      | 15-Year Fixed | 6    | 110000     | 10000        |
#      | 20-Year Fixed | 8    | 1200000    | 300000       |
#      | 10-Year Fixed | 10   | 560000     | 80000        |
#      | 30-Year Fixed | 5    | 880000     | 10000        |
#      | 15-Year Fixed | 6    | 9900000    | 500000       |
#      | 20-Year Fixed | 7    | 450000     | 50000        |