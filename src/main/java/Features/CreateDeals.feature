Feature: FreeCRM create new deal with paremerterization 

Scenario: FreeCRM create new deals through Data table with multiple set of data

	Given user is on login page 
	When title of the login page is CRM software for customer relationship management, sales, and support. 
	Then user enters username and password 
		|username   |password   |
		| shilpaabc | Sh$ln9606 |
		
	Then user clicks on login button 
	Then user is on homepage 
	Then user mouse hovet to the deal tab
	Then user click on New Deal link
	Then user fills the deals detail
	|title|amount|probability|commision|
	|deal1|1000|50|20| 
	|deal2|3000|40|10| 
	|deal3|200 |30|15|
	|deal4|4000|20|30| 
	
#	Then user click on save button
	Then close the browser 
