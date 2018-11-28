Feature: Contact Us Reset feature
		If a user clicks on the reset button then all information should be removed from the contact us form

Scenario: Enter information to the contact us form, the click the reset button and information will be removed
	Given I access webdriverunivirsity
	When I click on the contact us button
	And I enter an invalid first name
	And I enter an invalid last name
	And I enter an email address
	And I enter comments
	When I click on the reset button
	Then all information that was listed on the contact form will be removed