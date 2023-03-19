package Main;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import googleSearch.fetchData;


public class Execution {

	ChromeDriver driver = new ChromeDriver();
	
	int sheetnumberTCListFile=0;
	
	public String DataFileTestCasesList = "E:path\\TestCasesList.xlsx";
	public String pathOfGoogleChromeDriver = "E:path\\chromedriver.exe";
	
	public String DataFilePathDaraz = "E:path\\DarazSearchValues.xlsx";
	static boolean flagDaraz = false ;
	
	public String DataFilePathGoogle = "E:path\\DarazSearchValues.xlsx";
	static boolean flagGoogle = false ;
	
	public String DataFilePathPakwheels = "E:path\\DarazSearchValues.xlsx";
	static boolean flagPakwheels = false ;
	
	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver",pathOfGoogleChromeDriver);			
		driver.manage().window().maximize();
		
		//get which test cases needs to be executed!
		checkStatus();
		
	}
	
	@DataProvider
	public Iterator <String[]> getTestDataDaraz() {
		
		
		if (!flagDaraz) {
			throw new SkipException("Skipping Daraz Test case");
		}	
		
		fetchDataDaraz theDataObjectOfFile = new fetchDataDaraz(DataFilePathDaraz);
		ArrayList <String[]> theDataArray = theDataObjectOfFile.getData(0);
		System.out.println("data returning !");
		return theDataArray.iterator();
	
	}
	
	@DataProvider
	public Iterator <String[]> getTestDataGoogle() {
		
		if (!flagGoogle) {
			throw new SkipException("Google search Test case skipped !");
		}
		
		fetchDataGoogle theDataObjectOfFile = new fetchDataGoogle(DataFilePathGoogle);
		ArrayList <String[]> theDataArray = theDataObjectOfFile.getData(0);
		return theDataArray.iterator();
	
	}
	
	@DataProvider
	public Iterator <String[]> getTestDataPakwheels() {
				
		if (!flagPakwheels) {
			throw new SkipException("Pakwheels search Test case skipped !");
		}
		
		fetchDataPakwheels theDataObjectOfFile = new fetchDataPakwheels(DataFilePathPakwheels);
		ArrayList <String[]> theDataArray = theDataObjectOfFile.getData(0);
		return theDataArray.iterator();
	
		}
	
	
	@Test(dataProvider="getTestDataDaraz")
	public void TestCaseDarazSearch(String theValue) throws InterruptedException {
		
		
		if (!flagDaraz) {
			throw new SkipException("");
		}	
			
		driver.get("https://www.daraz.pk/");	
		Thread.sleep(500);
		
		driver.findElement(By.cssSelector("#q")).sendKeys(theValue);
		driver.findElement(By.cssSelector("#q")).sendKeys(Keys.ENTER);
		
		Thread.sleep(500);
		Assert.assertTrue(driver.getTitle().contains("www.daraz.pk"),"Page changed !");
		System.out.println("Search successful");
		
	}
	
	@Test(dataProvider="getTestDataGoogle")
	public void TestCaseGoogleSearch(String theValue) throws InterruptedException {
	
		if (!flagGoogle) {
			throw new SkipException("");
		}
			
		driver.get("https://www.google.com/");	
		Thread.sleep(500);
		
		driver.findElement(By.className("gLFyf")).sendKeys(theValue);
		driver.findElement(By.className("gLFyf")).sendKeys(Keys.ENTER);
		
		Thread.sleep(500);
		
		Assert.assertTrue(driver.getTitle().contains("Google Search"),"Incorrect search !");
		
		System.out.println("Search successful");
}
	
	
	@Test(dataProvider="getTestDataPakwheels")
	public void TestCasePakwheels(String theValue) throws InterruptedException {
		
		if (!flagPakwheels) {
			throw new SkipException("");
		}
			
		driver.get("https://www.pakwheels.com/");	
		Thread.sleep(500);
		
		driver.findElement(By.cssSelector("#home-query")).sendKeys(theValue);
		driver.findElement(By.cssSelector("#home-query")).sendKeys(Keys.ENTER);
		
		Select drpDownCity = new Select(driver.findElement(By.cssSelector("UsedCity")));
		drpDownCity.selectByVisibleText("Karachi");
		
		Thread.sleep(2000);
		
		//button[@id='home-search-btn' and @type='submit'  ]
		
		Thread.sleep(500);
		Assert.assertTrue(driver.getTitle().contains("Karachi | PakWheels"),"Page changed !");
		System.out.println("Search successful");
	
}
	public void checkStatus() {
		
		//Read file, if the case's name is found enabled than make it true !!!
		
		XSSFWorkbook work_book = null;
		XSSFSheet sheet;
		
		try {
			
			File s = new File(DataFileTestCasesList);
			FileInputStream stream = new FileInputStream(s);
			work_book = new XSSFWorkbook(stream);
			
			}
			catch(Exception e) {
			
			System.out.println(e.getMessage());
			
			}
	

		sheet = work_book.getSheetAt(sheetnumberTCListFile);

		int len = work_book.getSheetAt(sheetnumberTCListFile).getLastRowNum();
		len = len + 1;

		for (int i=1; i < len ; i ++) {
			
			//Get string and numeric values:
			String value = sheet.getRow(i).getCell(1).getStringCellValue();
			
			//If data is numeric
			//Double secNum = sheet.getRow(i).getCell(11).getNumericCellValue();
			
			if (value.equalsIgnoreCase("enable")) {
				
				value = sheet.getRow(i).getCell(0).getStringCellValue();
				
				//Finding which TC is enable
				
				if (value.equalsIgnoreCase("Google Search")) {
					flagGoogle = true;
				}
				if (value.equalsIgnoreCase("Daraz Search")) {
					flagDaraz = true;
				}
				if (value.equalsIgnoreCase("Pakwheels Search")) {
					flagPakwheels = true;
				}
				
			}
		
		}

		
	}
	
	
}
