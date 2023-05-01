package testCases;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.base;
import pages.contacts;
import pages.homePage;
import pages.loginPage;

public class homePageTest extends base{

	loginPage loginpage;
	homePage homepage;
	contacts contactspage;
	public homePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage = new loginPage();
		homepage = loginpage.dologin(prop.getProperty("email"), prop.getProperty("password"));
	}
	
	@Test(priority=1,enabled=false)
	public void validateTitle() {
		String t = homepage.validateTitle();
		System.out.println("the title found: "+t);
		Assert.assertEquals("Cogmento CRM",t);
	 }
	
	@Test(priority=2,enabled=false)
	public void validateUsername() {
		//Assert.assertTrue(homepage.validateUsername());
		assertTrue(homepage.validateUsername());
	}
	
	@Test(priority=3,enabled=false)
	public void clickOnContacts() {
		contactspage = homepage.clickOnContacts()  ;
	}
	
	@Test(priority=4)
	public void clickOnContactsByHovering() {
		homepage.hoverToContacts();
	}
	
	
	
	@AfterMethod
	public void end() {
		//driver.quit();
	}
}
