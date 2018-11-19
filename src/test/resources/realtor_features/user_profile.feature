Feature: perform different actions on my profile page

  Background:
    Given user login

  @EditProfileName
  Scenario: profile name should become equal "first name + last name"
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
  Scenario: values of modified fields on the profile page should accept the corresponding values.
    When user moved to my profile page
    And user click EditProfile button
    And user chooses: country = "United States", address = "streetNew", city = "cityNew", state = "Hawaii"
    And user click save changes button
    And user wait until profile location info become: "United States", "streetNew", "cityNew", "Hawaii"
    Then profile location info should be: country = "United States", address = "streetNew", city = "cityNew", state = "Hawaii"
    But user click EditProfile button
    And user chooses: state = "Arizona", address = "streetOld", city = "cityOld", country = "Togo"

  @EditMyHomeInfo
  Scenario: values of modified fields on the my home page should take the appropriate values
    When user move to my home page
    And user click EditHomeFacts button
    And user chooses bedrooms = "2", bathrooms = "1", car spaces = "3", square = "2987", lot size = "3781"
    And user click save button
    And user close verification window
    Then changed parameters should be; bedrooms = "2", bathrooms = "1", car spaces = "3", square = "2987", lot size = "3781"
    But user click EditHomeFacts button
    And user chooses bedrooms = "4", bathrooms = "3", car spaces = "1", square = "3030", lot size = "3485"
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