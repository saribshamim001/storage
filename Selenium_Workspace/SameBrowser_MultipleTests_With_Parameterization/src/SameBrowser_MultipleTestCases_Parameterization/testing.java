package SameBrowser_MultipleTestCases_Parameterization;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class testing {

	public static String driverPath = "/home/saribshamim/chromedriver";

	public static WebDriver driver;
	public static String textToSearch;
	
	
	@BeforeTest
	@Parameters({"keyWord"})
	public void setBrowserAndGetValues(String keyWord){

        System.setProperty("webdriver.chrome.driver", driverPath);        
        driver = new ChromeDriver();//
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


}
