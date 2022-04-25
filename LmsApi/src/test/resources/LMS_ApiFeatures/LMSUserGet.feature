@getTest
Feature: Retreive LMS User detail 

    Background:	 Login to LMS Api with valid credential
  	Given Enter with  Login User Name "APIPROCESSING" Passowrd "2xx@Success"
  	When Click Ok button
  	
   
 	  Scenario: Get all User details
    Given LMS API is up and running with User Endpoint
    When 	I Hit the GET Request 
    Then 	Response Success status code is 200
    And 	Displayed all User details
    And 	I Validate the response of all user request
    
    Scenario Outline: Get Existing User Details
    Given LMS API is running with User Endpoint and User Id "<UserId>" 
    When 	I Hit the GET Request with User Id "<UserId>"
    Then 	Response Success status code is 200
  	And 	Displayed Existing User "<UserId>" details
    And 	Validate the response of Single User
    
    Examples: 
    |	UserId  |
    | U1148		|
    | U1122		|
    | U1124	  |
    
    
    Scenario Outline:: Get Non Existing User Details
    Given LMS API is running with User Endpoint and User Id "<UserId>" 
    When 	I Hit the GET Request with User Id "<UserId>"
    Then 	Response Failed status code is 404
  	And 	Displayed  User Not Found
    
     Examples: 
    |	UserId  |
    | U0006		|
    | U0024		|
  
    