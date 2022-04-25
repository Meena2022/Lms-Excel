Feature: Check the Login credentials  

	Scenario Outline: Login to LMS Api with valid credential
	 	Given Enter with  Login User Name "<Username>" Passowrd "<Password>"
  	When Click Ok button 
  	Then Status Code is 200 and Authorization Successful
  Examples:
  | Username        | Password     |
  | APIPROCESSING   | 2xx@Success  |
  
  	
	Scenario Outline: Login to LMS Api with Invalid credential
  	Given Enter Invalid Login User Name "<Username>" Passowrd "<Password>"
   	When Click Ok button  
  	Then Status Code is <Code> Authorization Failed   
  	
  	
  Examples:
	| Username        | Password         | Code |
	| APIPROCESSING   | Success          | 401  |
	| APIPRO          | 2xx@Success      | 401  |
	| xGthj           | khtr             | 401  |