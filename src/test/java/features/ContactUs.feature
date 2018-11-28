Feature: Submit data to webdriveruniverity.com using contact us form
	A user should be able to submit information via the contact us form
	
@WDUTest
Scenario: Submit information using the contact us form
	Given I access webdriverunivirsity
	When I click on the contact us button
	And I enter first name
	And I enter last name
	And I enter an email address
	And I enter comments
	| example comment one | example comment two |
	When I click on the submit button
	Then the information should successfully be submitted via the contact us form
	
