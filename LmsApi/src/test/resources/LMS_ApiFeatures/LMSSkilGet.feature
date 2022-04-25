@getTest
Feature: Retreive LMS Skills detail 

		Background:	 Login to LMS Api with valid credential
  	Given Enter with  Login User Name "APIPROCESSING" Passowrd "2xx@Success"
  	When Click Ok button
  	
 	  Scenario: Get all Skill details
    Given LMS API is up and running with Skills Endpoint
    When 	I Hit the GET Request 
    Then 	Response Success status code is 200
    And 	Displayed all Skills details
    And 	I Validate the response of all Skills request
    
    Scenario Outline: Get Existing Skills Details
    Given LMS API is running with Skills Endpoint and Skill Id <SkillId>
    When 	I Hit the GET Request with Skills Id <SkillId>
    Then 	Response Success status code is 200
  	And 	Displayed Existing Skill Id <SkillId> details
    And 	Validate the response of single Skill
    
     Examples:
   | SkillId  | 
   | 525			| 
   | 173			| 
	 
    
    Scenario Outline: Get Non Existing Skills Details
    Given LMS API is running with Skills Endpoint and Skill Id <SkillId>
    When 	I Hit the GET Request with Skills Id <SkillId>
    Then 	Response Failed status code is 404
  	And 	Displayed  Skill Not Found
  	
  	 Examples:
   | SkillId  | 
   | 5033			| 
   | 5034			| 
	 | 5035     | 
  	
	
 	    
      
    
   