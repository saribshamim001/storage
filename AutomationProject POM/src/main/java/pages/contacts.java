package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.base;

public class contacts extends base{
	
	@FindBy(xpath="//span[ contains(text(),'Contacts') ]")
	WebElement contactsLabel;
	
	public contacts() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyLabel() {
		return contactsLabel.isDisplayed();
	}
	
	public specificContactPage selectContactByName(String name) {
		driver.findElement(By.xpath("//a[ text()='"+name+"' ]")).click();
		return new specificContactPage();
	}
}
