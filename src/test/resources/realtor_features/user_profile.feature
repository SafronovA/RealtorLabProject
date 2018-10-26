Feature: perform different actions on my profile page

  Background:
    Given user login

  @EditProfileName
  Scenario: user edit first and last name,
  profile name should become equal "first name + last name"
    When user moved to my profile page
    And user click EditProfile button
    And user changes first name to "NEW_FIRST_NAME" and last name to "NEW_LAST_NAME"
    And user click save changes button
    And user wait until profile name become: "NEW_FIRST_NAME", "NEW_LAST_NAME"
    Then profile name should be equal "NEW_FIRST_NAME NEW_LAST_NAME"
    But user click EditProfile button
    And user changes first name to "OLD_FIRST_NAME" and last name to "OLD_LAST_NAME"
    And user click save changes button

  @EditProfileLocation
  Scenario: user changes the address, city, state, and country field values,
  values of modified fields on the profile page should accept the corresponding values.
    When user moved to my profile page
    And user click EditProfile button
    And user edit country on "United States"
    And user edit address on "streetNew"
    And user edit city on "cityNew"
    And user edit state on "Hawaii"
    And user click save changes button
    And user wait until profile location info become: "United States", "streetNew", "cityNew", "Hawaii"
    Then profile country should be equal "United States"
    And profile address should be equal "streetNew"
    And profile city should be equal "cityNew"
    And profile state should be equal "Hawaii"
    But user click EditProfile button
    And user edit state on "Arizona"
    And user edit address on "streetOld"
    And user edit city on "cityOld"
    And user edit country on "Togo"
    And user click save changes button

  @EditMyHomeInfo
  Scenario: user changes the values of the number of bedrooms, bathrooms, car spaces, square and lot size,
  values of modified fields on the my home page should take the appropriate values
    When user move to my home page
    And user click EditHomeFacts button
    And user edit bedrooms on "2"
    And user edit bathrooms on "1"
    And user edit car spaces on "3"
    And user edit square on "2987"
    And user edit lot size on "3781"
    And user click save button
    And user close verification window
    Then my home bedrooms value should be equal "2"
    And my home bathrooms value should be equal "1"
    And my home car spaces value should be equal "3"
    And my home square value should be equal "2987"
    And my home lot size value should be equal "3781"
    But user click EditHomeFacts button
    And user edit bedrooms on "4"
    And user edit bathrooms on "3"
    And user edit car spaces on "1"
    And user edit square on "3030"
    And user edit lot size on "3485"
    And user click save button
    And user close verification window

  @SavedHomes
  Scenario: the user checks that the houses are saved correctly
    When user clear saved homes
    And  user save all homes on the main page and remember the number of houses saved
    Then  check if saved homes number match saved homes on the main page

  @SavedSearch
  Scenario: user checks that searches are saved correctly
    When user clear all old saved searches
    And user perform search by "San Francisco, CA"
    And user save "$350k" - "$600k" search
    Then user check that search saved with selected parameters: city "San Francisco, CA", min price "$350k", max price "$600k"