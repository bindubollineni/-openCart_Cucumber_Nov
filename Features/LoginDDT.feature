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
Feature: Login Test using data driven

  Scenario Outline: Successful Login with Credentials
    Given user launches browser
    And opens URL "http://opencart.abstracta.us/index.php?route=common/home"
    When user clicks MyAccount link
    And user clicks Login link
    And user enter email id "<email>"
    And user enter password "<password>"
    And user clicks Login button
    Then user navigates to MyAccount

    Examples: 
      | email                | password |
      | miyamiya12@gmail.com | miyamiya |
      | miyamiya@gmail.com   | miyamiya |
