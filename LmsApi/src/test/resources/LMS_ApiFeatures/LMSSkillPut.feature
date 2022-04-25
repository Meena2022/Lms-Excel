@putTest
Feature: Check Skill - PUT Request of  LMS API

  Background:	 Login to LMS Api with valid credential
  	Given Enter with  Login User Name "APIPROCESSING" Passowrd "2xx@Success"
  	When Click Ok button
  	
  Scenario Outline: Modify the data of Existing Skill Id
    Given LMS API is running with Skills Endpoint and Skill Id <SkillId> 
    When 	I Hit PUT request with skill name "<SkillName>" in Request body 
    Then  Response Success status code is 201
    And 	Displayed Successful Skill updated
    And 	I Validate Put response of Skills
    
   Examples:
   | SkillId  | SkillName				|
   | 543			| AWS cloud comp	|
   | 544			| Scrum Maste   	|
	 | 545      | dot Net 2       |
	 
   Scenario Outline:: Modify the data of Non existing Skill Id
    Given LMS API is running with Skills Endpoint and Skill Id <SkillId>
    When 	I Hit PUT request with skill name "<SkillName>" in Request body
    Then 	Response Failed status code is 404
    And 	Displayed Failed to update 
    
    Examples:
   | SkillId   | SkillName					|
   | 5033			 | Selenium  C			  |
   | 5034			 | Selenium  python	  |
	 | 5035      | Selenium   Java    |