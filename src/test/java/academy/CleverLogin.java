package academy;

import java.io.IOException;
import java.sql.Driver;
import java.util.Iterator;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.LoginPage;
import resources.base;

public class CleverLogin extends base {
	  public WebDriver driver;   // Can be used for pararell testing to avoid issues 
	  // Becasue drive has already been initiated in the base class
	  public static Logger log = LogManager.getLogger(base.class.getName());
	  
@BeforeTest
 public void initialize() throws IOException {
	
	 driver = initialiseDriver();
	 log.info("Driver is Initialized");
     driver.get(prop.getProperty("appURL"));
     driver.manage().window().maximize();
     
}
	// This is to map it to the get data 
   @Test
   public void LoginToClever() throws IOException
   {
	   LoginPage login = new LoginPage(driver);
	   Assert.assertTrue(login.enterEmail().isDisplayed());
	// LandingPage lp = new LandingPage(driver);
	// driver.get(prop.getProperty("appURL"));
	// Assert.assertEquals( lp.getTitle().getText(), "FEATURED COURSES");
	// Assert.assertTrue(lp.MenuTitle().isDisplayed());
	// log.info("Assertion Vompleted");
	 
	// lp.SignInLink().click();
       driver.switchTo().newWindow(WindowType.TAB);
       Set<String> handles = driver.getWindowHandles();
       Iterator<String> it = handles.iterator();
       String parentWindowid = it.next();
       String childwindow = it.next();
       driver.switchTo().window(childwindow);
  
      driver.get("https://clever.com/");
   } 

   

   @AfterTest
   public void teardown()
   {
 	  
 	  driver.close();
   }

}

   
  