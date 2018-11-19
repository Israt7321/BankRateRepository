Feature: BankRate calculation

  @tag1
  Scenario: User want to calculate mortgage
    Given User is on BankRate WebPage
    And User move on Mortgage manue and select  Mortgage calculation
    When User input HomePrice
    And User input DownPayment and percentage
    And User select the duration and interest rate
    And User click on calculate button
    Then The user will found the mortgage amount in dollar

  @tag2
  Scenario Outline: User want to calculate saving amount
    Given User will nevigate to Banking manue select Saving Calculator
    When user enter Initial Amopunt "<InitialAmount>",Monthly Deposit"<MonthlyDeposit>"
    And user enter Annual Interest "<AnnualInterest>" ,Number of years"<NumberOfYear>"
    And user will click on calculate button
    Then user will get the result of TotalAmount "<TotalAmount>"

    Examples: 
      | InitialAmount | MonthlyDeposit | AnnualInterest | NumberOfYear | TotalAmount |
      |         10000 |            100 |            6.5 |            2 | $13,939.90   |
      |         20000 |            150 |            6.3 |            5 | $37,929.21   |
