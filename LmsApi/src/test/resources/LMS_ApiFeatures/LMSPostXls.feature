Feature: Create new User,Skill,UserSkill Map with LMS endpoints and Valid Data 

Scenario: Create New User  
Given LMS API is up and running with User Endpoint
When I Hit the POST request with User data from Excel file sheet "user" 
Then Displayed status code 201

Scenario: Create New Skill 
Given LMS API is up and running with Skill Endpoint
When I Hit the POST request with Skill data from Excel file sheet "skill"
Then Displayed status code 201

 
Scenario: Create New User Skill Map    
Given LMS API is up and running with User Skill Endpoint
When I Hit the POST request with User Skill Map data from Excel file sheet "userskillmap"
Then Displayed status code 201

