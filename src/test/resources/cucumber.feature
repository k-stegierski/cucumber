Feature: Cash withdrawal from account

  Scenario: Withdrawing more money than available
    Given I have 200 PLN on mu account
    When I want to withdraw 500 PLN
    Then I should see error message "Insufficient funds to perform operation"
    Then I should see message "You have withdrawed 0 PLN"
    Then I should see remaining ballance

  Scenario Outline: Withdrawing
      Given I have 200 PLN on mu account
      When I want to withdraw <amount> PLN
      Then I verify if <amount> PLN is legit
      Then I should have <balance> PLN remaining on the account

        Examples:
          | amount | balance |
          | 0 | 200 |
          | 50 | 150 |
          | 100 | 100 |
          | 150 | 50 |
          | 200 | 0 |