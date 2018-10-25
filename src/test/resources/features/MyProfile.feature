Feature: perform different actions on my profile page

  Background:
    Given user logIn


  @EditProfileName
  Scenario: user edit first and last name,
  profile name should become equal "first name + last name"
    Given user moved to my profile page
    When user changes first name to "NEW_FIRST_NAME" and last name to "NEW_LAST_NAME"
    Then profile name should be equal "NEW_FIRST_NAME NEW_LAST_NAME"
# postconditions

  @EditProfileLocation
  Scenario: user changes the address, city, state, and country field values,
  values of modified fields on the profile page should accept the corresponding values.
    Given user moved to my profile page
    When user click EditProfile button
    And user edit country on "United States"
    And user edit address on "streetNew"
    And user edit city on "cityNew"
    And user edit state on "Hawaii"
    And user wait until profile location info become: "United States", "streetNew", "cityNew", "Hawaii"
    Then profile country should be equal "United States"
    And profile address should be equal "streetNew"
    And profile city should be equal "cityNew"
    And profile state should be equal "Hawaii"

# postconditions

  @EditMyHomeInfo
  Scenario: user changes the values of the number of bedrooms, bathrooms, car spaces, square and lot size,
  values of modified fields on the my home page should take the appropriate values
    Given user move to my home page
    When user click EditHomeFacts button
    And user edit bedrooms on "2"
    And user edit bathrooms on "1"
    And user edit car spaces on "3"
    And user edit square on "2987"
    And user edit lot size on "3781"

    Then my home bedrooms value should be equal "2"
    And my home bathrooms value should be equal "1"
    And my home car spaces value should be equal "3"
    And my home square value should be equal "<2987>"
    And my home lot size value should be equal "<3781>"
# postconditions


  @SavedHomes
  Scenario: the user checks that the houses are saved correctly
    Given user clear saved homes
    When  user save all homes on the main page and remember the number of houses saved
    Then  check if saved homes number match saved homes on the main page

  @SavedSearch
  Scenario: user checks that searches are saved correctly
    Given user clear all old saved searches
    Then user perform search by "San Francisco, CA"
    When  user save "$350k " - "$600k " search
    Then  user check that search saved with selected parameters:"$350k " - "$600k "
# postconditions

  @MortgageCalculator
  Scenario Outline: check that calculated and displayed price is correct
    Given move to mortgage calculator page
    When  select loan type as "<LOAN_TYPE>"
    And  select rate as "<RATE>"
    And  select home price as "<HOME_PRICE>"
    And  select down payment as "<DOWN_PAYMENT>"
    Then check that price calculated correctly with loan type = "<LOAN_TYPE>", rate = "<RATE>", home price = "<HOME_PRICE>", down payment = "<DOWN_PAYMENT>"

    Examples:
      | LOAN_TYPE     | RATE | HOME_PRICE | DOWN_PAYMENT |
      | 15-Year Fixed | 6    | 110000     | 10000        |
      | 20-Year Fixed | 8    | 1200000    | 300000       |
      | 10-Year Fixed | 10   | 560000     | 80000        |
      | 30-Year Fixed | 5    | 880000     | 10000        |
      | 15-Year Fixed | 6    | 9900000    | 500000       |
      | 20-Year Fixed | 7    | 450000     | 50000        |