package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.base;

public class loginPage  extends base{
	
	@FindBy(name="email")
	WebElement email;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//*[@class='ui fluid large blue submit button']")
	WebElement LoginBtn;
	
	public loginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateTitle() {
		return driver.getTitle();
	}
	
	public homePage dologin(String emailID, String pwd) {
		email.sendKeys(emailID);
		password.sendKeys(pwd);
		LoginBtn.click();
		return new homePage();
	}
}
