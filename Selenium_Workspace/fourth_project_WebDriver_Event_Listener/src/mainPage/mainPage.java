package mainPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class mainPage {

	WebDriver driver;
	
	//Constructor that will be automatically called as soon as the object of the class is created
	public mainPage(WebDriver driver) {
		this.driver=driver;
	}
	
	//Locator for search box
	By searchBox = By.cssSelector("#twotabsearchtextbox");
	By clickSearchButton = By.cssSelector("#nav-search-submit-button");
	
	
	//Type keyword
	public void sendKeyword(String keyWord) {
		
		driver.findElement(searchBox).sendKeys(keyWord);
	
	}
	
	//Click Search Button
	public void clickSearchButton() {
		
		driver.findElement(clickSearchButton).click();
	
	}
	
	
	
}
