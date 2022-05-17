Feature: Create new User,Skill,UserSkill Map all LMS endpoints

Scenario: Create New User with valid user data
Given LMS API is up and running with User Endpoint
When I Hit the POST request with User data from Excel file "c:\dos"
Then Displayed status code 200

Scenario: Create New Skill with valid skill data
Given LMS API is up and running with skill Endpoint
When I Hit the POST request with Skill data from Excel file "c:\dos"
Then Displayed status code 200

 
Scenario: Create New User Skill Map with valid User Skill Map data
Given: LMS API is up and running with User Skill Endpoint
When: I Hit the POST request with User Skill data from Excel file "c:\dos"
Then: Displayed status code 200

