package googleSearch;

import org.openqa.selenium.Keys;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class mySearch {

	//private static final Object Object = null;
		ChromeDriver driver = new ChromeDriver();
		
		@BeforeTest
		public void beforeTest() {
			System.setProperty("webdriver.chrome.driver","E:the path...");			
			driver.manage().window().maximize();
		}
		
		@Test
		public void searchTesla() throws InterruptedException {
			
			driver.get("https://www.google.com/");	
			Thread.sleep(500);
			driver.findElement(By.className("gLFyf")).sendKeys("Tesla");
			driver.findElement(By.className("gLFyf")).sendKeys(Keys.ENTER);
			Thread.sleep(500);
			Assert.assertTrue(driver.getTitle().matches("Tesla - Google Search"),"Incorrect search !");
			System.out.println("Search successful");
		}

		@Test
		public void searchBMW() throws InterruptedException {
			
			driver.get("https://www.google.com/");	
			Thread.sleep(500);
			driver.findElement(By.className("gLFyf")).sendKeys("BMW");
			driver.findElement(By.className("gLFyf")).sendKeys(Keys.ENTER);
			Thread.sleep(500);
			Assert.assertTrue(driver.getTitle().matches("BMW - Google Search"),"Incorrect BMW search !");
			System.out.println("Search 2 successful");
		}
		
		@AfterTest
		void ProgramTermination() {
			driver.quit();
		}

}
