@ui @healthcheck
Feature: E-commerce Project Website Health Checkup

@Login
Scenario: User is able to open the login page and fill the correct emailid and password
#Given user opened browser
Given user navigate to the home application url
When user click on Signup/Login button
Then Signup/Login page is displayed
Then user enter the correct emailid and password "gebat52405@vikinoko.com" and "123@ABC"
Then user click on login button
#Then user logged the username is displayed "Tom"
Then user clic on logout button