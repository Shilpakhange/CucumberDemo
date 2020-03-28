Feature: FreeCRM create contact page feature
Scenario Outline:: FreeCRM create contacts test scenario

    Given user on login page
    When the login page title is CRM software for customer relationship management, sales, and support.
    Then user provide "<username>" and "<password>"
    Then user clicks on submit button
    Then after login page title is CRMPRO
    Then user mousehover the contacts button.
    Then user clicks on create new contact link.
    Then user enters contact details "<firstname>" and "<lastname>" and "<company>"
    Then user clicks on save button
    Then shut the browser

    Examples:
    |username |password |firstname |lastname |company |
    |shilpaabc|Sh$ln9606|tom       |peter    |apple   |
    |shilpaabc|Sh$ln9606|reena     |sharma   |ebay    |
    |shilpaabc|Sh$ln9606|michel    |loreal   |microsoft|    