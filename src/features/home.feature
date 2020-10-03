#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@Alltestcases
Feature: Add registers from home
  As I user i want to add expenses or incomes from home

  @Addincomes
  Scenario: Add incomes
    Given Staying in home screen
    When I push button plus
    And I enter a value in the calculator
    And I Choose a category
    Then I View the amount reflected on the label to incomes

  @Addexpenses
  Scenario: Add expenses
    Given Staying in home screen for add expense
    When I push button minus
    And I enter a value in the expenses calculator
    And I Choose a category of expense
    Then I view the amount reflected on the label to expenses
    
   @Addinividualexpenses
   Scenario: Add individial expenses from home.
   	Given Staying in home screen for add individual expenses
   	Then I could add expenses individualy
   
   @Balancevalidation
   	Scenario: Validate Balance about an income and an expense
   	Given Staying in home screen to validate balance
   	When I add an income
   	And I add an expense
   	Then The Balance have to print the difference between both records

   
