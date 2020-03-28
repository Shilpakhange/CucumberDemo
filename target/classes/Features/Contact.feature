Feature: FreeCRM contacts page feature

Scenario: FreeCRM contacts page test scenario

Given User is on home page
When contacts tab is present on the contacts page
Then user mouse hover to the contacts page
Then user clicks on New Contact link
Then user selects title
Then user enters firtname and lastname
Then user clicks save button.
Then verify new contact is added