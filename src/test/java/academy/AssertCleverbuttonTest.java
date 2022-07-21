package academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.LoginPage;
import resources.base;

public class AssertCleverbuttonTest extends base {
	public WebDriver driver; 
	  public static Logger log = LogManager.getLogger(base.class.getName());
@BeforeTest
 
     public void initialize() throws IOException {
	
	 driver = initialiseDriver();
	 log.info("Driver is Initialized");
//	 chromeOptions = Options()
//	options.addArguments("--lang=en-GB");
	 driver.get(prop.getProperty("appURL"));
	 

	 
	 // Changes from driver.getURL
	 // driver.get("http://qaclickacademy.com"); 
      // driver.get(prop.getProperty("appURL"));
    driver.manage().window().maximize();
    log.info("Screen Maximized");
    
    }


	@Test
    public void VerifyLoginWithClever() throws InterruptedException 
    {	
		 
	LoginPage login = new LoginPage(driver);
	
	login.HaveAnAccessCode().click();
	Thread.sleep(2000);
	Assert.assertTrue(login.VerifyCleverBtn().isDisplayed());
	//Assert.assertEquals(login.VerifyCleverBtn().getText(), "Login with Clever");
	
	 
	 
	
  }

//   @AfterTest
 //  public void teardown()
//   {
//  	driver.close();
 // }
}