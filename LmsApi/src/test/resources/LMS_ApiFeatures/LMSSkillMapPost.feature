@postTest
Feature: Check User Skill - POST Request of  LMS API

	Background:	 Login to LMS Api with valid credential
  	Given Enter with  Login User Name "APIPROCESSING" Passowrd "2xx@Success"
  	When Click Ok button

  Scenario Outline: Create New User Skill Map with unique User Skill Id  
    Given LMS API is up and running with User Skill Endpoint
    When 	I Entered experience <experience>,skill Id <skillId>,User Id "<UserId>" in request body
    And   I Hit the POST Request of User Skill Map
    Then 	Post Response Success status code is 201
    And 	Displayed Successfuly Created with autogenerated User Skill Id
    And 	I Validate the POST response of User Skill 
    
   Examples:
   | experience | skillId   | UserId |
   | 12         | 7         | U853   |
   | 3          | 192       | U853   |

  Scenario Outline: Create New User Skill for Existing Skill,User
    Given LMS API is up and running with User Skill Endpoint
    When 	I Entered experience <experience>,skill Id <skillId>,User Id "<UserId>" in request body
    And   I Hit the POST Request of User Skill Map
    Then 	Post Response Failed status code is 400
    And 	Displayed Failed to create User Skill
    
   
    Examples:
   | experience | skillId   | UserId |
   | 10         | 4         | U1076  |
   | 24         | 530       | U1076  |
  