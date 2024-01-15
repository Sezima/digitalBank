@Registration
Feature: Digital Bank Registration Page

  Scenario: Positive Case. As a user, I want to create Digital Bank Account
    Given user navigates to Digital Bank signup page
    When User creates account with following fields with mocked email and ssn
      | title | firstName | lastName | gender | dob        | password    | address    | locality | region | postalCode | country | homePhone  | mobilePhone | workPhone  |
      | Mr.   | John      | Chuprin  | M      | 01/12/1990 | Password123 | 911 street | Sarasota | CA     | 34235      | USA     | 8056376873 | 3334445555  | 8053194670 |

    Then user should be displayed with the message "Registration Successful. Please Login."