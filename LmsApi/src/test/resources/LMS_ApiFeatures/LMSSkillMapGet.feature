@getTest
Feature: Retreive LMS User Skill Map detail

 
		Background:	 Login to LMS Api with valid credential
  	Given Enter with  Login User Name "APIPROCESSING" Passowrd "2xx@Success"
  	When Click Ok button
	
 	  Scenario: Get all User Skill Map details
    Given LMS API is up and running with User Skill Endpoint
    When 	I Hit the GET Request 
    Then 	Response Success status code is 200
    And 	Displayed all User Skill details
    And 	I Validate the response of all User Skill request
    
    Scenario Outline: Get Existing User Skill Details
    Given LMS API is running with User Skill Endpoint and User Skill Id "<UserSkillId>"
    When 	I Hit the GET Request with User Skill Id "<UserSkillId>"
    Then 	Response Success status code is 200
  	And 	Displayed Existing User Skill Id "<UserSkillId>" details
    And 	Validate the response of single User Skill 
    Examples:
    | UserSkillId |
    | US04				|
    | US18				|
    
    Scenario Outline:  Get Non Existing User Skill Id Details
    Given LMS API is running with User Skill Endpoint and User Skill Id "<UserSkillId>"
    When 	I Hit the GET Request with User Skill Id "<UserSkillId>"
    Then 	Response Failed status code is 404
  	And 	Displayed  User Skill  Not Found
  	
		    Examples:
    | UserSkillId |
    | US0004				|
    | US0018				|
 	    
      
    
   