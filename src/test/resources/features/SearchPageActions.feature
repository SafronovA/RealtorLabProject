
Feature: Perform different actions connected with search requests on SearchPage

  @MapMarks
  Scenario Outline: user create search request, user click any map mark on the iframe map,
                    map mark has information that fit search request criteria
    Given user perform search by "<CITY_NAME>"
    When user create search request by "<MIN_PRICE_VALUE>", "<MAX_PRICE_VALUE>","<BED_NUMBER>", "<BATH_NUMBER>","<MIN_SQFT_VALUE>", "<MAX_SQFT_VALUE>"
    Then prices on map marks on the iframe map should be between "<MIN_PRICE_VALUE>" and "<MAX_PRICE_VALUE>"
    And map marks on the iframe map should have beds more than "<BED_NUMBER>"
    And map marks on the iframe map should have baths more than "<BATH_NUMBER>"
    And house sqft on map marks on the iframe map should be between "<MIN_SQFT_VALUE>" and "<MAX_SQFT_VALUE>"

    Examples:
      |CITY_NAME    |MIN_PRICE_VALUE  |MAX_PRICE_VALUE  |BED_NUMBER |BATH_NUMBER  |MIN_SQFT_VALUE |MAX_SQFT_VALUE |
      |Berkeley, CA |$250k            |$1.4M            |2+         |2+           |1,750 sqft     |2,000 sqft     |

  @SearchByConditions
  Scenario Outline: user create search request, every result fit search request criteria
    Given user perform search by "<CITY_NAME>"
    When user create search request by "<MIN_PRICE_VALUE>", "<MAX_PRICE_VALUE>","<BED_NUMBER>", "<BATH_NUMBER>","<MIN_SQFT_VALUE>", "<MAX_SQFT_VALUE>"
    Then prices in search result should be between "<MIN_PRICE_VALUE>" and "<MAX_PRICE_VALUE>"
    And bed quantity in search results should have beds more than "<BED_NUMBER>"
    And bath quantity in search result should have baths more than "<BATH_NUMBER>"
    And house sqft in search result should be between "<MIN_SQFT_VALUE>" and "<MAX_SQFT_VALUE>"

    Examples:
      |CITY_NAME    |MIN_PRICE_VALUE  |MAX_PRICE_VALUE  |BED_NUMBER |BATH_NUMBER  |MIN_SQFT_VALUE |MAX_SQFT_VALUE |
      |Berkeley, CA |$250k            |$1.4M            |2+         |2+           |1,750 sqft     |2,000 sqft     |

  @FoundHouses
  Scenario: user create search request, check if number of found elements match result information
    Given user perform search by "Berkeley, CA"
    Then number of found houses match result information

  @SortByPrice
  Scenario Outline: user create search request, user choose sort option,
                    elements on the page displayed sort option
    Given user perform search by "<CITY_NAME>"
    When user create search request by price "<MIN_PRICE_VALUE>", "<MAX_PRICE_VALUE>"
    And user choose to sort houses by "<SORT_OPTION>"
    Then elements on the page displayed sorted by price

    Examples:
      |CITY_NAME          |MIN_PRICE_VALUE  |MAX_PRICE_VALUE   |SORT_OPTION     |
      |San Francisco, CA  |$350k            |$600k             |Highest Price   |

    @SchoolRating
    Scenario Outline: user create search request, user click on the "View map" button,
                      user click on "View school" button, user choose "High school" filter, user choose school rating,
                      schools that are displayed on map have rating more than selected
      Given user perform search by "<CITY_NAME>"
      When user click on View Map button
      And user choose high school and select school "<RATING>"
      Then schools that are displayed on map have rating more than selected "<RATING>"

      Examples:
        |CITY_NAME      |RATING  |
        |Anchorage, AK  |9       |

      @RestaurantsFilter
      Scenario: user create search request, user click on the "View map" button,
      user click on "Life Style" button, user select restaurants,
        all marks on the map are restaurants
        Given user perform search by "San Francisco, CA"
        When user click on View Map button
        And click on "Life Style" button and select restaurants
        Then all marks on the map are restaurants




