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
import PomClasses.ProfilePage;

public class VerifyUserCanAddNewAddress {
	
	
	static WebDriver driver;
	HomePage hp;
	ProfilePage pp;
	
	@BeforeClass
	public void beforeClass() throws IOException
	{
		driver = BaseClass1.getDriver("chrome");
	}
	
	@BeforeMethod
	public void beforeMethod()
	{
		hp = new HomePage(driver);
	}
	
	
	@Test
	public void verifyUserCanGoToProfilePage()
	{
		hp.moveToProfileName();
		hp.clickOnProfileText();
		hp.moveMouse(driver);
		pp = new ProfilePage(driver);
		Assert.assertTrue(pp.getFullProfileName());
		
	}
	
	@Test(priority=1)
	public void veryUserCanAddAddress() throws InterruptedException
	{
		
		pp.clickmanageAddressText();
		
		int previousAddressCount = pp.savedAddressCount();
		
		System.out.println(previousAddressCount);
		
		pp.clickAddAddressText();
		pp.fillAddressDetails();
		pp.fillMainAddress();
		pp.clickOnSaveBtn();
		Thread.sleep(1000);
		
		int currentAddressCount = pp.savedAddressCount();
		
		
		Assert.assertEquals(currentAddressCount, previousAddressCount + 1);
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
