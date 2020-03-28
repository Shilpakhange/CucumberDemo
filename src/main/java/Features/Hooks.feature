Feature: FreeCRM application test 

@First
Scenario: FreeCRM create a new task test
Given user is on tasks page
When user enters title and completion
|shilpa|50|
Then user verifies task is created for the below title
|shilpa|


#@second
#Scenario: FreeCRM create a new cases test
#Given user is on case page
#When user enters title 
#Then user verifies case is created

