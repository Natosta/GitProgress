package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	public WebDriver driver;
	
    /*
	By username=By.name("email");
	By pass_word=By.id("user_password");	
	By loginbtn=By.name("commit");
   */
	
	By username=By.name("UserName");
	By pass_word=By.id("Password");	
	By loginbtn=By.id("btnLogin");
	By HaveStudentAccesscode =By.xpath("(//a[@class='js-link psuedo-link'])[1]");
	By LoginWithClevebtn  =By.xpath("//a[@class='clever-sign-in ng-star-inserted']");
	
	
   
    // Constructor linked to home page 
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}



	public WebElement enterEmail()
	{
		return driver.findElement(username);
	}
	
	public WebElement enterPassword()
	{
		return driver.findElement(pass_word);
	}
	
	public WebElement clickOnLogin()
	{
		return driver.findElement(loginbtn);
	}

	public WebElement HaveAnAccessCode()
	{
		return driver.findElement(HaveStudentAccesscode);
	}
	
	
	public WebElement VerifyCleverBtn()
	{
		return driver.findElement(LoginWithClevebtn);
	}
	
	

}
