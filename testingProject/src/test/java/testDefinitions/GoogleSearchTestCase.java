package testDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.*;

public class GoogleSearchTestCase {
	
	static WebDriver driver = null;

	
	@Given("Browser is opened")
	public void browser_is_opened() {
		System.out.println("In setUP");	
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\dependencies\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		driver.manage().window().maximize();
	}

	@When("Open google website")
	public void open_google_website() {
		driver.get("http://google.com");
	}

	@When("^Enter details (.*?)$")
	public void enter_details(String searchItem) {
		driver.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys(searchItem);
	}

	@When("Press Enter")
	public void press_enter() {
		driver.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys(Keys.ENTER);
	}

	@Then("^Seach result must be displayed (.*?)$")
	public void seach_result_must_be_displayed(String searchValue) {
		String title = driver.getTitle();
		Assert.assertEquals(title, searchValue+" - Google Search");
		driver.quit();
	}


}
