Feature: realtor smoke tests
  #include only necessary test for realtor.com
  #
  #


   # @SmokeTest
    Scenario Outline:
    Given user perform search by "<CITY_NAME>"
    When user create search request by "<MIN_PRICE_VALUE>", "<MAX_PRICE_VALUE>","<BED_NUMBER>", "<BATH_NUMBER>","<MIN_SQFT_VALUE>", "<MAX_SQFT_VALUE>"
    Then prices on map marks on the iframe map should be between "<MIN_PRICE_VALUE>" and "<MAX_PRICE_VALUE>"
    Then map marks on the iframe map should have beds more than "<BED_NUMBER>"
    Then map marks on the iframe map should have baths more than "<BATH_NUMBER>"
    Then house sqft on map marks on the iframe map should be between "<MIN_SQFT_VALUE>" and "<MAX_SQFT_VALUE>"

      Examples:
        | CITY_NAME   | MIN_PRICE_VALUE | MAX_PRICE_VALUE |BED_NUMBER |BATH_NUMBER  |MIN_SQFT_VALUE |MAX_SQFT_VALUE |
        |Berkeley, CA |$250k            |$1.4M            |2+         |2+           |1,750 sqft     |2,000 sqft     |



