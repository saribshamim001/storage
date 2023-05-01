package testCases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;

import base.base;
import pages.homePage;
import pages.loginPage;

public class loginPageTest  extends base{
	loginPage loginpage;
	homePage homepage;
	public loginPageTest() {
		
		super();
		
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage = new loginPage();
	}
	
	@AfterMethod()
	public void end() {
		driver.quit();
	}

	@Test(priority=1)
	public void theTest() {
		String t = loginpage.validateTitle();
		AssertJUnit.assertEquals(t, "Cogmento CRM");
	}
	
	@Test(priority=2)
	public void testStarts() {
	homepage = loginpage.dologin(prop.getProperty("email"), prop.getProperty("password"));
	}
}
