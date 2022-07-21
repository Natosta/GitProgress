package resources;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {
	static ExtentReports extent;
	
	/*
    Create a class
	Add Extent report dependencies 
	add code and import 
	*/
	
	
		// Run first test to generate report folder 
		
		 public static ExtentReports getReportObject() {
			   
			String path =  System.getProperty("user.dir")+"\\reports\\index.html";
			 ExtentSparkReporter reporter = new ExtentSparkReporter(path);
			 reporter.config().setReportName("Web Automation Result");
			 reporter.config().setDocumentTitle("Test Result");
			 
			 // This is the main class responsible for driving the execution 
			 // Remove ExtentReports cos it's been declared above 
			 extent = new ExtentReports();
			 extent.attachReporter(reporter);
			 extent.setSystemInfo("Tester", "Andy Samuel");
			 return extent;
			  
		 }
		
		 @Test
		 public void initDemoFail() {
	         
	         // The extent test allows you to create more methods 
	        //  like fail or add a screen shot
			 ExtentTest test = extent.createTest("LoginNavigation");
			 System.setProperty("webdriver.chrome.driver","C:\\Users\\AndersonEgwurugwu\\chromedriver\\chromedriver.exe");	
			    WebDriver driver = new ChromeDriver();
			    driver.manage().window().maximize();
			    driver.get("https://rahulshettyacademy.com");
			    System.out.println(driver.getTitle());
			  //  test.fail("Didn't Match Andy");
			 //   test.addScreenCaptureFromBase64String("Say my name");
			    
			    extent.flush();
			
		 }
		 
	  
	}



