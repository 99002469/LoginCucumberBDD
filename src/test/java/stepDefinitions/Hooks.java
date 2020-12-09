package stepDefinitions;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

	static WebDriver driver;
	@Before
	public static void openBrowser()throws Exception {
		System.setProperty("webdriver.chrome.driver","src/test/resources/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://dev-portal.eastus.cloudapp.azure.com/#/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
	}
	
	@After
	public static void closeBrowser() throws Exception { 
		driver.close();
		
	}
	
}
