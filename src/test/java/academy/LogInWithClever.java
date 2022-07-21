package academy;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.LoginPage;
import resources.base;

public class LogInWithClever extends base {
	 public WebDriver driver;   // Can be used for pararell testing to avoid issues 
	  // Becasue drive has already been initiated in the base class
	@BeforeTest
	 
    public void initialize() throws IOException, InterruptedException {
	
		System.setProperty("webdriver.chrome.driver","C:\\Users\\AndersonEgwurugwu\\chromedriver\\chromedriver.exe");	
		
	
		
//	 Options = new Options();
		
		
	//	ChromeOptions options = new ChromeOptions();
	//	options.addArguments("--lang=en-us");
	  //  driver = new ChromeDriver();
	 //  ChromeDriver driver = new ChromeDriver(options);
	    
		
		
		
		// driver = initialiseDriver();

//	 chromeOptions = Options()
//			 options.addArguments("--lang=en-GB");
	// driver.get(prop.getProperty("appURL"));
	
	//System.setProperty("webdriver.chrome.driver","C:\\Users\\AndersonEgwurugwu\\chromedriver\\chromedriver.exe");	
	
	
	//options.addArguments("--lang=en-us");
	//ChromeDriver driver = new ChromeDriver(options);
    
    

	
  //  WebDriver driver = new ChromeDriver();
   
	
    driver.get("https://qa.worksonlocal.dev/");
    driver.manage().window().maximize();
	}
    
    @Test
    public void validateClev() throws IOException, InterruptedException
    {
    LoginPage login = new LoginPage(driver);
    Thread.sleep(3000);
    login.HaveAnAccessCode();
  

   
    
//    Add testng jar and create an object of softassert
//    SoftAssert ata = new SoftAssert();
    
    // Hard assert
//    Assert.assertTrue()
    
//    Soft assert
//    ata.Assert.assertTrue()
    
    
    // This would record all failed steps and fail test after execution 
//	    ata.assertAll();






    
    

	}


}


