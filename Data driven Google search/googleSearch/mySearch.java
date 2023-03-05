package googleSearch;

import org.openqa.selenium.Keys;

import java.util.ArrayList;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import program2.ReadExcelFile;

public class mySearch {

	//private static final Object Object = null;
		ChromeDriver driver = new ChromeDriver();
		
		@BeforeTest
		public void beforeTest() {
			System.setProperty("webdriver.chrome.driver","E:the path...");			
			driver.manage().window().maximize();
		}
		
		@DataProvider
		public Iterator <String[]> getTestData() {
			fetchData theDataObjectOfFile = new fetchData("E:\\the path...\\searchData.xlsx");
			ArrayList <String[]> theDataArray = theDataObjectOfFile.getData(0);
			return theDataArray.iterator();
		}
		
		@Test(dataProvider="getTestData")
		public void searchDifferentValues(String theValue) throws InterruptedException {
			driver.get("https://www.google.com/");	
			Thread.sleep(500);
			driver.findElement(By.className("gLFyf")).sendKeys(theValue);
			driver.findElement(By.className("gLFyf")).sendKeys(Keys.ENTER);
			Thread.sleep(500);
			Assert.assertTrue(driver.getTitle().contains("Google Search"),"Incorrect search !");
			System.out.println("Search successful");
		}
		
		@AfterTest
		void ProgramTermination() {
			driver.quit();
		}

}
