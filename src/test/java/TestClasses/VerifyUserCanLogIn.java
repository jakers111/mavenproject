package TestClasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BaseClasses.BaseClass1;
import PomClasses.HomePage;
import PomClasses.LoginPage;

public class VerifyUserCanLogIn {
	
	static WebDriver driver;
	LoginPage lp;
	
	@BeforeClass
	public void beforeClass() throws IOException
	{
		driver = BaseClass1.getDriver("chrome");
	}
	
	@BeforeMethod
	public void beforeMethod()
	{
		lp = new LoginPage(driver);
	}
	
	@Test
	public void verifyUserCanLogin() throws IOException, InterruptedException
	{
		lp.enterEmail();
		lp.enterPassword();
		lp.clickLoginBtn();
		
		HomePage hp = new HomePage(driver);
		
		Assert.assertTrue(hp.getProfileName());
	}
	
	
	@AfterMethod
	public void afterMethod()
	{
		
	}
	
	
	@AfterClass
	public void afterClass()
	{
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
