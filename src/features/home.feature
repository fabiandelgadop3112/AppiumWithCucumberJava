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
@tag
Feature: Add registers from home
	As I user i want to add expenses or incomes from home
	
  @tag1
  Scenario: Add incomes
  	Given Staying in home screen
    When 	I push button plus
    And 	I enter a value in the calculator
    And   I Choose a category
    Then  I View the amount reflected on the label to incomes
 


 
