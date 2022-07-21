package academy;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.ExtentReportNG;
import resources.base;

public class Listeners extends base implements ITestListener {
ExtentTest test;

	ExtentReports extent = ExtentReportNG.getReportObject();
//	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
	 ExtentTest test = extent.createTest(result.getMethod().getMethodName());
	}

	//@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test Passed");
	//	ITestListener.super.onTestSuccess(result);
	}

//	@Override
	public void onTestFailure(ITestResult result) {
	//	test.fail(result.getThrowable());
		//driver is null for the above test 
		WebDriver driver = null;
	//	return this.driver;
		String testMethodName = result.getMethod().getMethodName();
		
		try {
			
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (Exception e)
		
		{
		
		
		}
		try {
			getScreenShotPath(testMethodName, driver);
	}	catch (Exception e) {
		
		e.printStackTrace();
	  }
		
	}
	
	
	

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
	//.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	//	ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
	//	ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
	//	ITestListener.super.onStart(context);
	}

	//@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	//	ITestListener.super.onFinish(context);
	}

}
