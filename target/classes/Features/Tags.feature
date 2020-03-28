Feature: Free CRM application login feature

@smoke @regression 
Scenario: FreeCRM login page test scenario
Given User is on login page

@regression
Scenario: FreeCRM login test with correct username and password
Given User logins with correct credentials

@sanity @regression
Scenario: FreeCRM login test with incorect username and password
Given User gives incorrect credentials

@regression
Scenario: FreeCRM create a contact
Given User is on new contacts page.

@end2end
Scenario: FreeCRM create a deal
Given User is on new deals page

@sanity
Scenario: FreeCRM create a new tasks
Given User is on new task page

@smoke
Scenario: FreeCRM create new  case
Given User is on new case page

@sanity
Scenario: FreeCRM verity left panel functionality
Given User is on left panel page

@regression
Scenario: FreeCRM create a mail
Given User is on new mail page

@smoke
Scenario: FreeCRM search a tasks
Given User is on task page

@regression @smoke
Scenario: FreeCRM search a deal
Given User is on deals page

@end2end
Scenario: FreeCRM search a case
Given User is on cases page

@smoke
Scenario: FreeCRM search a contat
Given User is on contacts page






