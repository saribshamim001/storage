package testCases;

import org.testng.Assert;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.base;
import pages.contacts;
import pages.homePage;
import pages.loginPage;
import pages.specificContactPage;
import utility.utilities;

public class contactsPageTest extends base {
	loginPage loginpage;
	homePage homepage;
	contacts contactspage;
	utilities utils;
	specificContactPage specificcontactPage;
	String name = "Ahmed Ali";
	
	public contactsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage = new loginPage();
		utils = new utilities();
		contactspage = new contacts();
		specificcontactPage = new specificContactPage();
		homepage = loginpage.dologin(prop.getProperty("email"), prop.getProperty("password"));
		contactspage = homepage.clickOnContacts();
	}
	

	@AfterMethod
	public void end() {
		driver.quit();
	}
	
	@Test (priority=1)
	public void verifyContactsPageLabel() {
		Assert.assertTrue(contactspage.verifyLabel(),"contact label is not found !");
	}
	
	@Test(priority=2)
	public void selectName() {
		specificcontactPage = contactspage.selectContactByName(name);
	}

	@Test(priority=3)
	public void createNewContact() {
		
	}
}
