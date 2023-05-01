package pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.base;

public class homePage extends base {

	@FindBy(xpath="//*[contains(text(),'Sarib Shamim')]")
	WebElement usernameLabel;
	
	@FindBy(xpath="//*[@class='users icon']")
	WebElement contactsBtn;
	
	@FindBy(xpath="//*[@class='tasks icon']")
	WebElement tasksBtn;

	@FindBy(xpath="//*[@class='users icon']")
	WebElement contactsIcon;
	
	public homePage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateUsername() {
		return usernameLabel.isDisplayed();
	}
	
	public String validateTitle() {
		return driver.getTitle();
	}
	
	public contacts clickOnContacts() {
		contactsBtn.click();
		return new contacts();
	}
	
	public tasks clickOnTasks() {
		tasksBtn.click();
		return new tasks();
	}
	
	public void hoverToContacts() {
		Actions action = new Actions(driver);
		action.moveToElement(contactsIcon).build().perform();
		//ArrayList<WebElement> list = new ArrayList<>(driver.findElements(locator));
		ArrayList<WebElement> plusBtns = new ArrayList();
		plusBtns = (ArrayList<WebElement>) driver.findElements(By.xpath("//button[@class='ui mini basic icon button']"));
		plusBtns.get(1).click();
	}
}
