package stepDefinitions;


import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginUi {
//	static WebDriver driver = Hooks.driver;
	Hooks hook = new Hooks();
	WebDriver driver = Hooks.driver;
	
	@Given("^The login page is open on the browser$")
	public void the_login_page_is_open_on_the_browser() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		//System.setProperty("webdriver.chrome.driver","D:\\L&T Technology Services\\chromedriver.exe"); //Launching the browser
		//driver.get("https://dev-portal.eastus.cloudapp.azure.com/#/"); /*URL to Open the browser*/	
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
	}

	@When("^Enter the user name \"([^\"]*)\"$")
	public void enter_the_user_name(String Email) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("email")).sendKeys(Email);
	    System.out.println(Email);
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	     
	}

	@When("^Enter the Password \"([^\"]*)\"$")
	public void enter_the_Password(String Password) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("password")).sendKeys(Password);
	    System.out.println(Password);
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	     
	}

	@Then("^Login button should be Enabled$")
	public void login_button_should_be_Enabled() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//span[contains(text(),'LOG IN')]")).isEnabled();
		//Assertion or SOP
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	     
	}

	@When("^click on login button$")
	public void click_on_login_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//span[contains(text(),'LOG IN')]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
		
	}

	@Then("^Error message \"([^\"]*)\" Should be displayed$")
	public void error_message_Should_be_displayed(String errorMessage) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		//String ActualError = driver.findElement(By.xpath("//*[@id= 'mat-error-3']")).getText();

		String ActualError = driver.findElement(By.xpath("//*[@class = 'ng-tns-c16-0 ng-trigger ng-trigger-transitionMessages ng-star-inserted']")).getText();
		if(ActualError == "E-mail is required" || ActualError == "E-mail must be a valid email address" || ActualError == "Invalid Email or Password")
		{
		//Get the Error text and assert it
		Assert.assertEquals(errorMessage,ActualError);
		System.out.println("|" +ActualError + " -> Actual Error " + "|" + errorMessage + " -> Expected Error "+"|");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		String ActualErrorBlank = driver.findElement(By.xpath("//*[@class= 'ng-tns-c16-1 ng-trigger ng-trigger-transitionMessages ng-star-inserted']")).getText();
		if(ActualErrorBlank == "Password is required")
		{
			Assert.assertEquals(errorMessage,ActualErrorBlank);
			System.out.println("|" +ActualErrorBlank + " -> Actual Error " + "|" + errorMessage + " -> Expected Error "+"|");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		
		
	}

	@When("^Remember me Check box unchecked$")
	public void remember_me_Check_box_unchecked() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		if(driver.findElement(By.xpath("//div[@class='mat-checkbox-inner-container']")).isSelected() == false)
		{
			System.out.println("The Remember me Check box is Unchecked");
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}

//	@When("^Click on the Logout Button$")
//	public void click_on_the_Logout_Button() throws Throwable {
//	    // Write code here that turns the phrase above into concrete actions
//		 driver.get(""); //URL of the FADR home page
//		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		 
//	}

	@Then("^The user is Logged out successfully$")
	public void the_user_is_Logged_out_successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		String logoutScuccess = driver.findElement(By.xpath("//*[@class= 'account-label']")).getText();
		Assert.assertEquals(logoutScuccess, "Need an account?");	
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Then("^the Email text box should not be auto populated with the Email$")
	public void the_Email_text_box_should_not_be_auto_populated_with_the_Email() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		WebElement NullEmail = driver.findElement(By.id("email"));
		String verifyAssertNull = NullEmail.getAttribute("email"); //If the email text box turns out to be null, this test case shall pass
		Assert.assertNull(verifyAssertNull);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^Remember me Check box checked$")
	public void remember_me_Check_box_checked() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//div[@class='mat-checkbox-inner-container']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

//	@Then("^the Email text box should be auto populated with the Email$")
//	public void the_Email_text_box_should_be_auto_populated_with_the_Email() throws Throwable {
//	    // Write code here that turns the phrase above into concrete actions
//		WebElement Email = driver.findElement(By.id("email"));
//		String ACtualOutcome = Email.getAttribute("email");
//		String ExpectedOutcome =  "fadr_support_admin@eaton.com"; //Email that is auto populated in the login page.
//		//assertArrayEquals(ACtualOutcome, ExpectedOutcome);
//		Assert.assertEquals(ExpectedOutcome, ACtualOutcome);
//		Thread.sleep(3000);
//	}

	@When("^Clicked on the Forgot Password link$")
	public void clicked_on_the_Forgot_Password_link() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//a[@class='forgot-password']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Then("^User should be redirected to Forgot Password Page$")
	public void user_should_be_redirected_to_Forgot_Password_Page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		//driver.findElement(By.xpath("//*[@class = 'forgot-password']")).click();//URL to the Forgot password link
		//Assert some text in forgot password page
		String actualText = driver.findElement(By.xpath("//a[contains(text(),'800-356-3292')]")).getText();
		Thread.sleep(1000);
		Assert.assertEquals("800-356-3292", actualText);
	    //driver.findElement(By.xpath("//*[text()=' Back ']")).click(); //Click on the back button on the screen 
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^Click on the Contact Eaton Support$")
	public void click_on_the_Contact_Eaton_Support() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//a[@class='contact-eaton']")).click();;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Then("^A pop up window shall open showing the support details$")
	public void a_pop_up_window_shall_open_showing_the_support_details() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		String actualText = driver.findElement(By.xpath("//a[contains(text(),'CST@eaton.com')]")).getText();
		Assert.assertEquals("CST@eaton.com", actualText);
	    driver.findElement(By.xpath("//*[text()=' Okay ']")).click(); //Clicking the Okay button on the pop up
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Then("^Password should be masked$")
	public void password_should_be_masked() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//*[text()='visibility_off ']")).click();
		driver.findElement(By.id("password")).getAttribute("password");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^clicked on password eye$")
	public void clicked_on_password_eye() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//mat-icon[@class='matIcon mat-icon notranslate material-icons mat-icon-no-color']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Then("^Password should be visible$")
	public void password_should_be_visible() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//mat-icon[@class='matIcon mat-icon notranslate material-icons mat-icon-no-color']")).click();
		driver.findElement(By.id("password")).getAttribute("password");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

}
