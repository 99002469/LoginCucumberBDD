Feature: Verify the login page

#@UI
#Scenario: Validating the login page with valid credentials
# 
#	 Given The login page is open on the browser
#	 When Enter the valid username
#	 And Enter the valid Password
#	 Then Login button should be Enabled
#	 When Click on the Login button 
#	 Then Navigate to the FADR Home page

#@UI 
Scenario Outline: Verify Login with invalid credentials
	  Given The login page is open on the browser
	  When Enter the user name "<User name>"
	  And Enter the Password "<Password>" 
	  Then Login button should be Enabled
	  When click on login button
	  Then Error message "<Error Message>" Should be displayed
	  
 Examples:
 	|Description    		  |User name					|Password|Error Message				    	  |
 	|Invalid Email   		  |fadradmin@eaton.com			|random	 |Invalid Email or Password			  |
 	|Invalid Password		  |fadr_support_admin@eaton.com	|qwerty  |Invalid Email or Password			  |
 	|Invalid User and Password|fadradmin@eaton.com			|qwerty  |Invalid Email or Password			  |
 
 Scenario Outline: Verify login with invalid email format
 	Given The login page is open on the browser
	  When Enter the user name "<User name>"
	  And Enter the Password "<Password>" 
	  Then Login button should be Enabled
	  When click on login button
	  Then Error message "<Error Message>" Should be displayed
 Examples:
 	|Description    		  |User name					|Password|Error Message				    	  |
 	|Invalid Email Format	  |fadradmin					|qwert`	 |E-mail must be a valid email address|
 
 
@UI 
Scenario Outline: Login with Blank credentials
	 Given The login page is open on the browser
	 When Enter the user name "<User name>"
	 And Enter the Password "<Password>"
	 Then Login button should be Enabled
	 When click on login button
	 Then Error message "<Error Message>" Should be displayed
	 
 Examples:
 	|Description			|User name					  |Password |Error Message				    |
 	|Blank Email			|		 					  |qwerty	|E-mail is Required  			|
 	|Blank Password			|fadr_support_admin@eaton.com |			|Password is Required			|
 	|Blank User and Password|		 					  |			|E-mail and Password is Required|
	

@UI 
Scenario: Remember me checkbox is unchecked
	 Given The login page is open on the browser
	 When Enter the user name "fadr_support_admin@eaton.com"
	 And Enter the Password "qwerty" 
	 Then Login button should be Enabled
	 When Remember me Check box unchecked
	 When click on login button
#	 Then Home page of FADR is open 
#	 When Click on the Logout Button 
	 Then The user is Logged out successfully 
	 Then the Email text box should not be auto populated with the Email 

@UI	  
Scenario: Remember me checkbox is checked
	 Given The login page is open on the browser
	 When Enter the user name "fadr_support_admin@eaton.com"
	 And Enter the Password "qwerty" 
	 Then Login button should be Enabled
	 When Remember me Check box checked
	 When click on login button 
#	 Then Home page of FADR is open 
#	 When Click on the Logout Button 
	 Then The user is Logged out successfully 
#	 Then the Email text box should be auto populated with the Email  

@UI	@ForgotPassword
Scenario: Verify the forgot password link
	Given The login page is open on the browser   
	When Clicked on the Forgot Password link 
	Then User should be redirected to Forgot Password Page

@UI @Support
Scenario: Verify the Contact Eaton Support
	Given The login page is open on the browser
	When Click on the Contact Eaton Support
	Then A pop up window shall open showing the support details
	
@UI 	
Scenario: Verify if the password is unmasked
	 Given The login page is open on the browser
	 When Enter the user name "fadr_support_admin@eaton.com"
	 And Enter the Password "qwerty" 
	 Then Login button should be Enabled
	 Then Password should be masked
	 When clicked on password eye
	 Then Password should be visible

@UI	 
Scenario: Verify if the password is masked
	 Given The login page is open on the browser
	 When Enter the user name "fadr_support_admin@eaton.com"
	 And Enter the Password "qwerty" 
	 Then Login button should be Enabled
	 Then Password should be masked
	 
