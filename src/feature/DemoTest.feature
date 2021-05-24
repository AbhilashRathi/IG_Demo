#Author: Abhilash Rathi


Feature: To check the functionality of Donate now feature 

  @test
  Scenario Outline: To verify Donate now functionality
    Given I am on a login page
    When I click on username password button
    And I login to Donate now page
    And I click on Donate now button
    And I enter amount as <amountMoney>
    And I enter name as <name>
    And I enter Email as <emailID>
    And I enter phone number as <contactNumber>
    And I enter Billing city as <cityName>
    And I click on Donate now
    And I enter card details as <cardNumber> and <monthYear> and <cvv>
    Then I click on contribute
    And I verify the confirm message
    

    Examples: 
       | amountMoney | name  | emailID | contactNumber | cityName |cardNumber|monthYear|cvv|
       |     100 | Test Demo| Test@demo.com | 1234512345 | Mumbai |5555555555554444|10/24| 345 |
   #    |     1000 | Test Demo2| Test@demo2.com | 1234514345 | Mumbai |5555555555554444|10/22| 375 |
   
   @negative
  Scenario Outline: To verify Donate now functionality
    Given I am on a login page
    When I click on username password button
    And I login to Donate now page
    And I click on Donate now button
    Then I enter amount as <amountMoney>
    And I verify the minimum amount error message
    
     Examples: 
       | amountMoney |
       |   20        |
    
       