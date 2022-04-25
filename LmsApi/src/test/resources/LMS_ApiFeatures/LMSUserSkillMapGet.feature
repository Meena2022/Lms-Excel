@getTest
Feature: Retreive LMS User skill Map detail 
		
		Background:	 Login to LMS Api with valid credential
  	Given Enter with  Login User Name "APIPROCESSING" Passowrd "2xx@Success"
  	When Click Ok button
	
 	  Scenario: Get all User Skill Map details
    Given LMS API is up and running with User Skill Map Endpoint
    When 	I Hit the GET Request 
    Then 	Response Success status code is 200
    And 	Displayed all User Skill Map details
    And 	I Validate the response of all User Skill Map request
    
    Scenario Outline: Get all User Skill Map details for given User Id
    Given LMS API is up and running with User Skill Map Endpoint and User Id "<UserId>"
    When 	I Hit the GET Request 
    Then 	Response Success status code is 200
    And 	Displayed User Id "<UserId>" User Skill Map details
    And 	I Validate the response of User Skill Map request based on User Id
    
    Examples:
    | UserId  |
    | U847		|
    
    Scenario Outline: Get all User Skill Map details for given Skill Id
    Given LMS API is up and running with User Skill Map Endpoint and Skill Id <skillId>
    When 	I Hit the GET Request 
    Then 	Response Success status code is 200
    And 	Displayed Skill Id <skillId> User Skill Map details
    And 	I Validate the response of User Skill Map request based on Skill Id
    
    Examples:
    | skillId |
    | 523	    |