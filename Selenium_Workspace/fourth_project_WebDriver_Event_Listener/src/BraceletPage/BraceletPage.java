package BraceletPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BraceletPage {
	
	WebDriver driver;
	
	public BraceletPage(WebDriver driver) {
		this.driver=driver;
	}

	By clickItem = By.xpath("//*[ text()='Bulova Mens Marine Star Leather Bracelet' ] ");
	
	public void itemToClick() {
	
	driver.findElement(clickItem).click();
	
		
	}
	
}
