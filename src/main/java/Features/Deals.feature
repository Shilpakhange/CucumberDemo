Feature: FreeCRM create new deal 

Scenario: FreeCRM create new deals through Data table 

	Given user is on login page 
	When title of the login page is CRM software for customer relationship management, sales, and support. 
	Then user enters username and password 
		| shilpaabc | Sh$ln9606 |
	Then user clicks on login button 
	Then user is on homepage 
	Then user mouse hovet to the deal tab
	Then user click on New Deal link
	Then user fills the deals detail
	|deal1|1000|50|20| 
	|deal2|200 |30|15|
	Then user click on save button
	Then close the browser 
