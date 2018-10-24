Feature: perform different actions on my profile page

  Background:
    Given user logIn

  @EditProfileName
  Scenario Outline: user edit first and last name,
  profile name should become equal "first name + last name"
    Given user moved to my profile page
    When user edit profile name by "<FIRST_NAME>", "<LAST_NAME>"
    Then profile name should be equal "<FIRST_NAME> + <LAST_NAME>"
# postconditions

    Examples:
      | FIRST_NAME | LAST_NAME |
      | New_Lo     | New_ko    |

  @EditProfileName
  Scenario: user edit first and last name,
  profile name should become equal "first name + last name"
    Given user moved to my profile page
    When user changes first name to "NEW_FIRST_NAME" and last name to "NEW_LAST_NAME"
    Then profile name should be equal "NEW_FIRST_NAME NEW_LAST_NAME"
# postconditions

  @EditProfileLocation
  Scenario Outline: user changes the address, city, state, and country field values,
  values of modified fields on the profile page should accept the corresponding values.
    Given user moved to my profile page
    When user edit profile address by "<ADDRESS>", "<CITY>", "<STATE>", "<COUNTRY>"
    Then profile address should be equal "<ADDRESS>"
    Then profile city should be equal "<CITY>"
    Then profile state should be equal "<STATE>"
    Then profile country should be equal "<COUNTRY>"
# postconditions

    Examples:
      | ADDRESS   | CITY    | STATE  | COUNTRY       |
      | streetNew | cityNew | Hawaii | United States |


  @EditMyHomeInfo
  Scenario Outline: user changes the values of the number of bedrooms, bathrooms, car spaces, square and lot size,
  values of modified fields on the my home page should take the appropriate values
    Given user moved to my home page
    When user edit home information by "<BEDROOMS>", "<BATHROOMS>", "<CAR_SPACES>", "<SQUARE>", "<LOT_SIZE>"
    Then my home bedrooms value should be equal "<BEDROOMS>"
    Then my home bathrooms value should be equal "<BATHROOMS>"
    Then my home car spaces value should be equal "<CAR_SPACES>"
    Then my home square value should be equal "<SQUARE>"
    Then my home lot size value should be equal "<LOT_SIZE>"
# postconditions

    Examples:
      | BEDROOMS | BATHROOMS | CAR_SPACES | SQUARE | LOT_SIZE |
      | 2        | 1         | 3          | 2987   | 3781     |

  @SavedHomes
  Scenario: the user checks that the houses are saved correctly
    Given user clear saved homes
    When  save all homes on the main page
    Then  check if saved homes number match saved homes on the main page

  @SavedSearch
  Scenario Outline: user checks that searches are saved correctly
    Given user clear all old saved searches
    When user enter "<CITY_NAME>"
    And  user save "<MIN_PRICE>", "<MAX_PRICE>" search
    Then  user check that search saved with selected parameters "<MIN_PRICE>", "<MAX_PRICE>"
# postconditions
    Examples:
      | CITY_NAME         | MIN_PRICE | MAX_PRICE |
      | San Francisco, CA | $350k     | $600k     |

  @MortgageCalculator
  Scenario Outline: check that calculated and displayed price is correct
    Given move to mortgage calculator page
    When  select "<LOAN_TYPE>"
    And  select "<RATE>"
    And  select "<HOME_PRICE>"
    And  select "<DOWN_PAYMENT>"
    Then check that price calculated correctly with "<LOAN_TYPE>", "<RATE>", "<HOME_PRICE>", "<DOWN_PAYMENT>"

    Examples:
      | LOAN_TYPE     | RATE | HOME_PRICE | DOWN_PAYMENT |
      | 15-Year Fixed | 6"   | 110000     | 10000        |
      | 20-Year Fixed | 8    | 1200000    | 300000       |
      | 10-Year Fixed | 10   | 560000     | 80000        |
      | 30-Year Fixed | 5    | 880000     | 10000        |
      | 15-Year Fixed | 6    | 9900000    | 500000       |
      | 20-Year Fixed | 7    | 450000     | 50000        |