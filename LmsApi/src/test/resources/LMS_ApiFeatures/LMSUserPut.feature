@putTest
Feature: Check User - PUT Request of  LMS API

  Background:	 Login to LMS Api with valid credential
  	Given Enter with  Login User Name "APIPROCESSING" Passowrd "2xx@Success"
  	When Click Ok button
  	
  Scenario Outline: Modify the data of Existing User
    Given LMS API is running with User Endpoint and User Id "<UserId>" 
    When 	I Entered Comment "<Comment>",Pg "<Pg>",Ug "<Ug>",Linkedin "<Linkedin>",Location "<Location>",Name "<Name>",Phone <Phone>,Tzone "<Tzone>",Visa "<Visa>" in Put request body 
   	And  	I Hit the PUT request with User Id "U1105"
    Then 	PUT Response Success status code is 201
    And 	Displayed Successful user updated
    And 	I Validate the response of Put request
    
   Examples:
   | UserId |  Comment   | Pg  | Ug  | Linkedin                       | Location  | Name        | Phone     | Tzone  | Visa |
	 | U1122  | SDET -Lead | ME  | BE	 | https://www.linkedin.com/linke | Florida  |Jack,Sparrow | 123443210  | EST    | H4   |
	 | U1123  |SDET -Sr    | MSc | Bsc | https://www.linkedin.com/linke | Los Angles|Will,Smith   | 234554320 | PST    | H4   |

   Scenario Outline: Modify the data of Non existing User
    Given LMS API is running with User Endpoint and User Id "<UserId>"  
    When 	I Entered Comment "<Comment>",Pg "<Pg>",Ug "<Ug>",Linkedin "<Linkedin>",Location "<Location>",Name "<Name>",Phone <Phone>,Tzone "<Tzone>",Visa "<Visa>" in Put request body 
   	And 	I Hit the PUT request with User Id "U0"
    Then 	PUT Response Failed status code is 404
    And 	Displayed Failed to update 
    
      Examples:
   | UserId |  Comment   | Pg  | Ug  | Linkedin                       | Location  | Name        | Phone     | Tzone  | Visa |
	 | U10122  | SDET -Lead | ME  | BE	 | https://www.linkedin.com/linke | Florida  |Jack,Sparrow | 123443210  | EST    | H4   |
	 | U10123  |SDET -Sr    | MSc | Bsc | https://www.linkedin.com/linke | Los Angles|Will,Smith   | 234554320 | PST    | H4   |
