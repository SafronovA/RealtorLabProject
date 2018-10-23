Feature: perform different actions on my profile page


  Scenario Outline: Edit profile name
    Given user perform logIn and moved to my profile page
    When user edit profile name by "<FIRST_NAME>", "<LAST_NAME>"
    Then profile name should be equal "<FIRST_NAME> + <LAST_NAME>"

    Examples:
      | FIRST_NAME | LAST_NAME |
      | New_Lo     | New_ko    |


  Scenario Outline: Edit profile address
    Given user perform logIn and moved to my profile page
    When user edit profile address by "<ADDRESS>", "<CITY>", "<STATE>", "<COUNTRY>"
    Then profile address should be equal "<ADDRESS>"
    Then profile city should be equal "<CITY>"
    Then profile state should be equal "<STATE>"
    Then profile country should be equal "<COUNTRY>"

    Examples:
      | ADDRESS   | CITY    | STATE  | COUNTRY       |
      | streetNew | cityNew | Hawaii | United States |


  Scenario Outline: Edit my home info
    Given user perform logIn and moved to my home page
    When user edit home information by "<BEDROOMS>", "<BATHROOMS>", "<CAR_SPACES>", "<SQUARE>", "<LOT_SIZE>"
    Then my home bedrooms value should be equal "<BEDROOMS>"
    Then my home bathrooms value should be equal "<BATHROOMS>"
    Then my home car spaces value should be equal "<CAR_SPACES>"
    Then my home square value should be equal "<SQUARE>"
    Then my home lot size value should be equal "<LOT_SIZE>"

    Examples:
      | BEDROOMS | BATHROOMS | CAR_SPACES | SQUARE | LOT_SIZE |
      | 2        | 1         | 3          | 2987   | 3781     |

