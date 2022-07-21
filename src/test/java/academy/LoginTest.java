package academy;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.LandingPage;
import pageObject.LoginPage;
import resources.base;

public class LoginTest extends base {
	public WebDriver driver; 
	  public static Logger log = LogManager.getLogger(base.class.getName());
@BeforeTest
   
   public void initialize() throws IOException {
	
	 driver = initialiseDriver();
	 log.info("Driver is Initialized");
	 // Changes from driver.getURL
	 // driver.get("http://qaclickacademy.com"); 
     // driver.get(prop.getProperty("appURL"));
     driver.manage().window().maximize();
  }
 	// This is to map it to the get data 
     @Test(dataProvider = "getData")
     public void LoginNavigation(String Username,String Password) throws IOException
    {	
	// LandingPage lp = new LandingPage(driver);
	 driver.get(prop.getProperty("appURL"));
	// Assert.assertEquals( lp.getTitle().getText(), "FEATURED COURSES");
	// Assert.assertTrue(lp.MenuTitle().isDisplayed());
	// log.info("Assertion Vompleted");
	 
	// lp.SignInLink().click();
	 
	 LoginPage login = new LoginPage(driver);
	 login.enterEmail().sendKeys("Username");
	 login.enterPassword().sendKeys("Password");
	 login.clickOnLogin().click();
	 
	//  System.out.println(text);
	  System.out.println("Valid Login Passed");
	  System.out.println("Invalid Login Passed");
	// login.clickOnLogin().click();
	 
   }


  @AfterTest
  public void teardown()
  {
	  
	  driver.close();
  }


    // Row stands for how many different data types test should run 
  
  // Provides data and parameterisation
  @DataProvider  
  public Object[][] getData()
  {
  	//1 Stands for how many test your running (index starts from 0)
  	//2 stands for how many values your sending per test (ie. username and password)  
  	Object[][] data = new Object[2][2];
  	
  	//0th row
  	data[0][0] = "anderson.egwurugwu@gl-education.com";
  	data[0][1]  = "Password";
  //	data[0][2] = "text";
  	//first row
  	data[1][0] = "anderson.egwurugwu@gl-education.com";
  	data[1][1] = "Password_1";
  //	data[1][2] = "text";
  	
  	return data;
  }  
  
  
  // Put this in every class


 
  
}


