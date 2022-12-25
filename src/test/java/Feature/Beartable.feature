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
Feature: Assert the bear table
Background:
Given user navigates to url 

  @color
  Scenario: Assert the beartable
  When user user takes color from the bear table
  Then Asserts the color with expected color
  @Weight  
  Scenario: Assert the cat table
  When user takes  values  from the weight coloumn
  Then Asserts with given weight
  @description
  Scenario: Assert the row size and decription length
  When user take srow size and description length
  Then Asserts it with expectded value