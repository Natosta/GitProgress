package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	public WebDriver driver;
	
	
	
	By signin=By.xpath("//a[@href='https://rahulshettyacademy.com/sign_in/']");

	// Used to assert test 
	By title =By.xpath("(//div[@class='text-center'])[1]");
	
	By Menu =By.xpath("//ul[@class='nav navbar-nav navbar-right'][li]");
	
	
	
	
	
     
    // Constructor linked to home page 
	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}



	public WebElement SignInLink()
	{
		return driver.findElement(signin);
	}
	
	public WebElement getTitle()
	{
		return driver.findElement(title);
	}
	
	
	public WebElement MenuTitle()
	{
		return driver.findElement(title);
	}
	
	
	
	
}
