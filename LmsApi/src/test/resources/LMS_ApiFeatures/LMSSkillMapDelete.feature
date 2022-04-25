@deleteTest
Feature: Check User Skill Map - DELETE Request of  LMS API

	Background:	 Login to LMS Api with valid credential
  	Given Enter with  Login User Name "APIPROCESSING" Passowrd "2xx@Success"
  	When Click Ok button
  	
  Scenario Outline: Delete the data of Existing User Skill Id
    Given LMS API is running with User Skill Endpoint and User Skill Id "<UserSkillId>"  
		When  I Hit the Delete request with User Skill Id "<UserSkillId>"
    Then 	Response Success status code is 200
    And 	Displayed Successful User Skill Id "<UserSkillId>" deleted
   
  Examples:
  |  UserSkillId |
  |  US681       |
  |  US682       |
  
 
   Scenario Outline: Delete the data of Non existing Skill
    Given  LMS API is running with User Skill Endpoint and User Skill Id "<UserSkillId>"  
    When 	I Hit the Delete request with User Skill Id "<UserSkillId>" 
    Then 	Response Failed status code is 404
    And 	Displayed  User Skill Not Found 
    
    Examples:
  |  UserSkillId |
  |  US00622       |
  |  US00623       |