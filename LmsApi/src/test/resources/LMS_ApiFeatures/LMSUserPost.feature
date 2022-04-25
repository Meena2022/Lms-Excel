@postTest
Feature: Check User - POST Request of  LMS API

  Background:	 Login to LMS Api with valid credential
  	Given Enter with  Login User Name "APIPROCESSING" Passowrd "2xx@Success"
  	When Click Ok button
  	
     
  Scenario Outline: Create New User with unique User Id and Phone number through POST request 
    Given LMS API is up and running with User Endpoint
    When 	I Entered Comment "<Comment>",Pg "<Pg>",Ug "<Ug>",Linkedin "<Linkedin>",Location "<Location>",Name "<Name>",Phone <Phone>,Tzone "<Tzone>",Visa "<Visa>" in request body 
   	And 	I Hit the POST Request 
    Then 	Post Response Success status code is 201
    And 	Displayed Successfuly Created with autogenerated UserId
    And 	I Validate the POST response 
   
   Examples:
   |  Comment   | Pg  | Ug  | Linkedin                       | Location | Name        | Phone     | Tzone  | Visa |
	 | QA -Lead   | ME  | BE	| https://www.linkedin.com/linke |  FL      |Bill,Gates		| 1234567891| EST    | H4   |
	 | Develope-Sr| MSc | Bsc | https://www.linkedin.com/linke |  NC      |Joe,Biden    | 2345671622| PST    | H4   |
	 | Web Dev    | MCA | BCA	| https://www.linkedin.com/linke |  KN      |Marry,Poppins| 3454562220| CST    | H4   |
	 
  Scenario Outline: Create New User for Existing Phone number through POST request 
    Given LMS API is up and running with User Endpoint
    When 	I Entered Comment "<Comment>",Pg "<Pg>",Ug "<Ug>",Linkedin "<Linkedin>",Location "<Location>",Name "<Name>",Phone <Phone>,Tzone "<Tzone>",Visa "<Visa>" in request body 
   	And 	I Hit the POST Request 
    Then 	Post Response Failed status code is 400
    And 	Displayed Failed to create user

Examples:
   |  Comment   | Pg  | Ug  | Linkedin                       | Location | Name        | Phone     | Tzone  | Visa |
	 | SDET -Lead | ME  | BE	| https://www.linkedin.com/linke |  FL      |Jack,Sparrow | 123443210 | EST    | H4   |
	# | SDET -Sr   | MSc | Bsc | https://www.linkedin.com/linke |  TN      |Will,Smith   | 234554320 | PST    | H4   |
	
  Scenario Outline:  Check that user name contain , or not
    Given LMS API is up and running with User Endpoint
    When 	I Entered Comment "<Comment>",Pg "<Pg>",Ug "<Ug>",Linkedin "<Linkedin>",Location "<Location>",Name "<Name>",Phone <Phone>,Tzone "<Tzone>",Visa "<Visa>" in request body 
   	And 	I Hit the POST Request 
    Then 	Post Response Failed status code is 400
    And 	Displayed Failed to create user

  Examples:
   |  Comment   | Pg  | Ug  | Linkedin                       | Location | Name  | Phone     | Tzone  | Visa |
	 | SDET -Lead | ME  | BE	| https://www.linkedin.com/linke |  FL      |Jack S | 111443210 | EST    | H4   |
	# | SDET -Sr   | MSc | Bsc | https://www.linkedin.com/linke |  TN      |Will T | 222554320 | PST    | H4   |
  

	
 

