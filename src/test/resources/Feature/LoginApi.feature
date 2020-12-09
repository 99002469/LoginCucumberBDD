Feature: Verify the login page for API 

#@LoginAPI
#Scenario: Validation of Login API with Valid Credentials 
#	 Given Rest Login and valid end point avalilable
#	 And Enter the valid Request Body
#	 When Made a rest call with Post method to the Valid End Point
#	 Then Validate the Status Code
#	 And Validate the Response Code
#	 And Validate the Response Content received

 
 #Login API for invalid credentials 
 
Scenario Outline: Verify the login API for invalid credentials
 	Given User prepares request body using <RequestBody> for Login API
    When User makes POST request on Login API
    Then Status code for Security API returns <status_code>
    And Error code for Security API returns <error_code>
    And Error description for Security API returns <error_desc>
 	Examples: 
        |Test description			    |RequestBody					 	|status_code|error_code |error_desc									  |
        |Test with invalid email format |LoginWithInvalidEmailFormat.json	|400		|9007		|Please provide valid email address			  |
        |Test with invalid password	    |LoginWithInvalidPassword.json	 	|401		|9001		|Unauthorized access	 					  |
        |Test with Unregistered email   |LoginWithUnregisteredEmail.json 	|401		|9001		|Unauthorized access						  |
        |Test with blank email		    |LoginWithBlankEmail.json			|400		|1001		|User name or password cannot be null or empty|
        |Test with blank password	    |LoginWithBlankPassword.json		|400		|1001		|User name or password cannot be null or empty|
        |Test without credentials	    |LoginWithoutCredentials.json	 	|400		|1001		|User name or password cannot be null or empty|
        |Test without email attribute   |LoginWithoutEmailAttribute.json 	|400		|1001		|User name or password cannot be null or empty|
        |Test without password attribute|LoginWithoutPasswordAttribute.json |400		|1001		|User name or password cannot be null or empty|