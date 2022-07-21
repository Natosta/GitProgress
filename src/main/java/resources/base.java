package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;




public class base {
	
   // So various instance of driver can be used on chrome 
	public WebDriver driver;
	
	// This is to help access the prop from other class
	public Properties prop;


	// Global
	public WebDriver initialiseDriver() throws IOException {
	
		
		// Property Class
//	Properties prop = new Properties();
	// Changing to prop so i can access url as well declared variable 
		
	prop = new Properties();
	FileInputStream fis = new FileInputStream("C:\\Users\\AndersonEgwurugwu\\eclipseworkspace\\E2eGlProjectTest\\src\\main\\java\\resources\\data.properties");
	
	prop.load(fis);
	String browserName = prop.getProperty("browser");
	System.out.println(browserName);
	
	

		
		
		
//	String browserUrl = prop.setProperty("browserUrl", browserUrl);
	
	if(browserName.equals("chrome"))
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\AndersonEgwurugwu\\chromedriver\\chromedriver.exe");	
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--lang=en-us");
		 driver = new ChromeDriver(options);	
	     
	//    if(browserName.equals("chrome"))
	//	{
	//		System.setProperty("webdriver.chrome.driver","C:\\Users\\AndersonEgwurugwu\\chromedriver\\chromedriver.exe");	
	//	    driver = new ChromeDriver();	
		          
	    
	    
	}
	
	else if (browserName.equals("firfox"))
	{
	//	System.setProperty("webdriver.chrome.driver","C:\\Users\\AndersonEgwurugwu\\FirefoxDriver.exe");	
	     driver = new FirefoxDriver();
	}
	
	else if (browserName.equals("IE"))
	{
	//	System.setProperty("webdriver.chrome.driver","C:\\Users\\AndersonEgwurugwu\\IEDriver.exe");	
	  //  driver = new msedgeDriver();
    }
	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	
	return driver;
	}
	
	
	public void getScreenShotPath(String testCaseName, WebDriver driver) throws IOException
	{
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\reports\\"+ testCaseName +".png";
		FileUtils.copyFile(source, new File(destinationFile));
		
	}
 }

