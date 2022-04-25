@putTest
Feature: Check User Skill Map - PUT Request of  LMS API

	Background:	 Login to LMS Api with valid credential
  	Given Enter with  Login User Name "APIPROCESSING" Passowrd "2xx@Success"
  	When Click Ok button

  Scenario Outline: Modify the Experience of Existing User Skill Id
    Given LMS API is running with User Skill Endpoint and User Skill Id "<UserSkillId>" 
    When 	I Entered experience <experience>,skill Id <skillId>,User Id "<UserId>" in PUT request body
    And   I Hit the PUT Request of User Skill Id "<UserSkillId>"
    Then  Response Success status code is 201
    And 	Displayed Successful User Skill updated
    And 	I Validate Put response of User Skill Map
    
   Examples:
   | UserSkillId| experience | skillId   | UserId |
   | US635      | 12         | 4         | U1076  |
   | US636      | 25         | 530       | U1076  |
    
  Scenario Outline: Modify the User Id of Existing User Skill Id
    Given LMS API is running with User Skill Endpoint and User Skill Id "<UserSkillId>" 
    When 	I Entered experience <experience>,skill Id <skillId>,User Id "<UserId>" in PUT request body
    And   I Hit the PUT Request of User Skill Id "<UserSkillId>"
    Then  Response Failed status code is 404
    And 	Displayed Failed to update User skill Map
    
    Examples:
   | UserSkillId| experience | skillId   | UserId |
   | US635      | 12         | 4         | U06    |
   | US636      | 25         | 530       | U12    |
 
    
  Scenario Outline: Modify the Skill Id of Existing User Skill Id
    Given LMS API is running with User Skill Endpoint and User Skill Id "<UserSkillId>" 
    When 	I Entered experience <experience>,skill Id <skillId>,User Id "<UserId>" in PUT request body
    And   I Hit the PUT Request of User Skill Id "<UserSkillId>"
    Then  Response Failed status code is 404
    And 	Displayed Failed to update User skill Map

 	Examples:
   | UserSkillId| experience | skillId   | UserId  |
   | US635      | 12         | 108       | U1076   |
   | US636      | 25         | 7         | U1076   |

   Scenario Outline: Modify the data of Non existing User Skill Id
    Given LMS API is running with User Skill Endpoint and User Skill Id "<UserSkillId>"
    When 	I Entered experience <experience>,skill Id <skillId>,User Id "<UserId>" in PUT request body
    And   I Hit the PUT Request of User Skill Id "<UserSkillId>"
    Then 	Response Failed status code is 404
    And 	Displayed Failed to update User skill Map
    
    	Examples:
   | UserSkillId | experience | skillId   | UserId  |
   | US00635     | 12         | 108       | U1076   |
   | US00636     | 25         | 7         | U1076   |