Feature: Login Portal
	Tests around validating login portal
	
#Must be ran in chrome due to issue with login page
	
@Testing @Chrome	
Scenario Outline: Login to account with credentials
	Given user navigates to "<url>"
	And user clicks on the login portal button
	And user enters "<username>" username
	And user enters "<password>"
	When user clicks on the login button
	Then the user should be prompted with the following prompt alert "<message>"
	
	Examples:
	|	url								  |	username	|	password	|	message				|
	| http://www.webdriveruniversity.com/ | webdriver   | webdriver  	| validation failed     |
	| http://www.webdriveruniversity.com/ | webdriver	| webdriver123	| validation succeeded	|
	
	