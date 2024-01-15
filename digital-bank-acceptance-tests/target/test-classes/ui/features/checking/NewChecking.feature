Feature: Creating a new checking account

  Scenario: Create a standard individual checking account
    Given the user logged in as "tapgala1@gmail.com" "Elonmusk1"
    When the user creates a new checking account with the following date
      | checkingAccountType | accountOwnership | accountName            | initialDepositAmount |
      | Standard Checking   | Individual       | Miguel Second Checking | 100000.0             |
    Then the user should see the green "Successfully created new Standard Checking account named Miguel Second Checking" message
    And the user should see newly added account card
      | accountName            | accountType       | ownership  | accountNumber | interestRate | balance   |
      | Miguel Second Checking | Standard Checking | Individual | 486132029     | 0.0%         | 100000.00 |
    And the user should see the following transaction
      | date            | category | description             | amount     | balance    |
      | 2023-09-22 07:4 | Income   | 845322736(DPT) - Deposit | 100000.0 | 100000.0 |
