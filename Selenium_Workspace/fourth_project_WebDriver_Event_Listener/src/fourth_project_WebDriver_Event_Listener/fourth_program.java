package fourth_project_WebDriver_Event_Listener;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import BraceletPage.BraceletPage;
import mainPage.mainPage;

public class fourth_program {

	public static WebDriver driver;
	public static WebElement searchBox;
	public static WebElement searchBoxButton;
	public static WebElement itemToClick;
	public static String keyWord;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		keyWord = "Men's Bracelet";
		
		//Open Amazong.com
		driver.get("https://www.amazon.com/");
		
				
		/*searchBox = driver.findElement(By.cssSelector("#twotabsearchtextbox"));
		//Type keyword
		searchBox.sendKeys(keyWord);
		
		
		searchBoxButton = driver.findElement(By.cssSelector("#nav-search-submit-button"));
		//Click search button
		searchBoxButton.click();
		

		itemToClick = driver.findElement(By.xpath("//*[ text()='Bulova Mens Marine Star Leather Bracelet' ] "));
		//Click on the bracelet
		itemToClick.click();
		
		*/
		
		mainPage mainPAGE = new mainPage(driver);
		BraceletPage braceLetePage = new BraceletPage(driver);
		
		//Type keyword
		mainPAGE.sendKeyword(keyWord);
		
		//Click search button
		mainPAGE.clickSearchButton();
		
		//Click on the bracelet
		braceLetePage.itemToClick();
		
		
		
		//Test Ends !
		System.out.println("Test Ends !");
		
	}

}
