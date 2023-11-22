package third_project_short_basis;


import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class learning {

	

	String driverPath = "C:\\LOCAL DRIVE D\\Selenium\\chromedriver_win32\\chromedriver.exe";
	WebDriver driver;
	private static String textToSearch;
	
	
	@BeforeTest
	@Parameters({"keyWord"})
	public void setBrowserAndGetValues(String keyWord){

        System.setProperty("webdriver.chrome.driver", driverPath);        
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        textToSearch = keyWord;
      
        driver.manage().window().maximize();
        
	
	}
	
	@Test
	public void openBrowser() {
		
		driver.get("https://google.com");
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys(textToSearch);
		
		
		
	}	
	
	@AfterTest
	public void shutDown() {
		
		
		System.out.println("Test Ends !");
		//driver.quit();
		
		
	}

}
