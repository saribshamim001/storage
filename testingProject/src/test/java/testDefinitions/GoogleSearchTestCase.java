package testDefinitions;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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

	@And("^Enter details with data (.*?)$")
	public void enter_details(String path) throws IOException {
		
	    FileInputStream fis = new FileInputStream(path);
	    
	    Workbook workbook = WorkbookFactory.create(fis);
	    Sheet sheet = workbook.getSheetAt(0);

	    // Iterate over rows
	    for (Row row : sheet) {
	        // Get cell value from the first column
	        Cell cell = row.getCell(0, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
	        cell.setCellType(CellType.STRING);
	        String searchItem = cell.getStringCellValue();
	        System.out.println("The obtained value: "+searchItem);
	        // Enter search item in the search field
	        driver.findElement(By.name("q")).sendKeys(searchItem);

	        // Click the search button or press Enter
	        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);

	        // Wait for search results to load
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.titleContains(searchItem + " - Google Search"));

	        // Clear the search field for the next iteration
	        driver.findElement(By.name("q")).clear();
	    }

	    fis.close();
	    workbook.close();
	}

	


}
