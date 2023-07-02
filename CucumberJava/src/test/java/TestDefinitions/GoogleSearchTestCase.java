package TestDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import Data.fetchData;
import io.cucumber.java.en.*;

public class GoogleSearchTestCase {
	
	static WebDriver driver = null;
//	private String theValue ="ChatGpt is dumb";
	
	
	@Given("That browser is opened")
	public void that_browser_is_opened() {
		System.out.println("In setUP");	
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\Dependencies\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		driver.manage().window().maximize(); 
		driver.get("https://www.google.com/");
	}
	
	//^Enter details with data (.*?)$ When Google is opened, I will enter a keyword to search at the <sheet> and the <row>
	@When("^Google is opened, I will enter a keyword to search at the (.*?) and the (.*?)$")
	public void google_is_opened_i_will_enter_a_keyword_to_search(String sheet,int row) {
		fetchData theDataObjectOfFile = new fetchData("E:\\searchData.xlsx");
		String theData = theDataObjectOfFile.getData(sheet,row);
		System.out.println("the data obtained: "+theData);
		driver.findElement(By.xpath("//textarea[ @class='gLFyf' ]")).sendKeys(theData);
	}
	
	
	
	@When("I will press Enter")
	public void i_will_press_enter() {
		driver.findElement(By.xpath("//textarea[ @class='gLFyf' ]")).sendKeys(Keys.ENTER);	
	}
	
	@Then("^the other page must be opened and results should be displayed of the (.*?) and the (.*?)$")
	public void the_other_page_must_be_opened_and_results_should_be_displayed(String sheet,int row) {
		
		fetchData theDataObjectOfFile = new fetchData("E:\\searchData.xlsx");
		String theData = theDataObjectOfFile.getData(sheet,row);
		Assert.assertEquals(driver.getTitle(), theData+" - Google Search");
	}
	
	@Then("I will close the browser")
	public void i_will_close_the_browser() {
		driver.quit();
	}
	
}
