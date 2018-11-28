Feature: Login portal
	Use the website's login portal to log in as user
	
Background:
	Given I access webdriverunivirsity
	And I enter a username

	
Scenario: Login account with valid password
	And I enter a "valid" password
	When I click on the login button
	Then I should be presented with a successful validation alert
	
Scenario: Login account with invalid password
	And I enter a "invalid" password
	When I click on the login button
	Then I should be presented with a successful validation alert