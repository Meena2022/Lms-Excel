@deleteTest
Feature: Check User - DELETE Request of  LMS API

  Background:	 Login to LMS Api with valid credential
  	Given Enter with  Login User Name "APIPROCESSING" Passowrd "2xx@Success"
  	When Click Ok button
  	
  Scenario Outline: Delete the data of Existing User
    Given LMS API is running with User Endpoint and User Id "<UserId>"  
		When  I Hit the Delete request with User Id "<UserId>"
    Then 	Response Success status code is 200
    And 	Displayed Successful User "<UserId>" deleted
    
    Examples: 
    |	UserId   |
    | U1105		 |
 		| U1096		 |
 
   Scenario Outline: Modify the data of Non existing User
    Given  LMS API is running with User Endpoint and User Id "<UserId>"  
    When 	I Hit the Delete request with User Id "<UserId>" 
    Then 	Response Failed status code is 404
    And 	Displayed  User Not Found 
    
    Examples: 
    |	UserId  |
    | U0006		|
    | U0024		|
