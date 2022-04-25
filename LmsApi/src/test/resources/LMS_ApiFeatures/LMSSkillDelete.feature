@deleteTest
Feature: Check Skills - DELETE Request of  LMS API

	Background:	 Login to LMS Api with valid credential
  	Given Enter with  Login User Name "APIPROCESSING" Passowrd "2xx@Success"
  	When Click Ok button
  	
  Scenario Outline: Delete the data of Existing Skill
    Given LMS API is running with Skills Endpoint and Skill Id <SkillId>  
		When  I Hit the Delete request with Skill Id <SkillId> 
    Then 	Response Success status code is 200
    And 	Displayed Successful Skill id <SkillId> deleted
    
    Examples:
   | SkillId  | 
   | 105			| 
   | 535			| 
 
   Scenario Outline: Delete the data of Non existing Skill
    Given  LMS API is running with Skills Endpoint and Skill Id <SkillId>   
    When 	I Hit the Delete request with Skill Id <SkillId> 
    Then 	Response Failed status code is 404
    And 	Displayed  Skill Not Found 
    
     Examples:
   | SkillId  | 
   | 5033			| 
   
   | 5034			| 
 