package TestNGListener;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import graphql.Assert;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;


public class TestCases {

SoftAssert softAssert = new SoftAssert();	
	
WebDriver driver = null;

@BeforeTest
@Parameters("browser")
public void beforeTest(String browser) throws Exception {
	
	if (browser.equalsIgnoreCase("firefox")) {
	
		System.setProperty("webdriver.gecko.driver","C:\\Selenium\\geckodriver-v0.30.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		
	}
	
	else if (browser.equalsIgnoreCase("chrome")) {
		
		System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		
	}	
	
	else {
		throw new Exception("Browser is not correct !");
		
	}
	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	
}
	
@Parameters("browser")	
@Test 
public void BrowseToAdactinWebsite(String browser) throws InterruptedException {
	
	
	
	driver.get("https://adactinhotelapp.com/HotelAppBuild2/");
	
	driver.findElement(By.id("username")).sendKeys("saribshamim1");
	driver.findElement(By.id("password")).sendKeys("QWer12345");
	
	Thread.sleep(500);
	
	driver.findElement(By.className("login_button")).click();
	
	Select drpDownLocation = new Select(driver.findElement(By.id("location")));
	drpDownLocation.selectByVisibleText("Sydney");
	
	Select drpDownRoomNos = new Select(driver.findElement(By.id("room_nos")));
	drpDownRoomNos.selectByIndex(8);
	
	driver.findElement(By.id("datepick_in")).sendKeys("1/05/2022");
	driver.findElement(By.id("datepick_out")).sendKeys("5/05/2022");

	Select drpDownAdultsPerRoom = new Select(driver.findElement(By.id("adult_room")));
	drpDownAdultsPerRoom.selectByValue("3");
	
	Thread.sleep(500);
	
	driver.findElement(By.id("Submit")).click();
	
	WebElement radioBtn = driver.findElement(By.id("radiobutton_4"));							
            		
    //Radio Button1 is selected		
    radioBtn.click();
    
    Thread.sleep(500);
    
    driver.findElement(By.id("continue")).click();
	
	
	JavascriptExecutor jse = (JavascriptExecutor) driver;
	jse.executeScript("window.scrollBy(0,700)");
	
	driver.findElement(By.id("first_name")).sendKeys("Sarib");
	driver.findElement(By.id("last_name")).sendKeys("Shamim");
	driver.findElement(By.id("address")).sendKeys("2nd Street, Downtown, L.A");
	
	
	driver.findElement(By.id("cc_num")).sendKeys("1234123412341234");
	Select drpDownCC_Type = new Select(driver.findElement(By.id("cc_type")));
	drpDownCC_Type.selectByIndex(1);
	Select drpDownExp_Month = new Select(driver.findElement(By.id("cc_exp_month")));
	drpDownExp_Month.selectByValue("2");
	Select drpDownExp_Year = new Select(driver.findElement(By.id("cc_exp_year")));
	drpDownExp_Year.selectByVisibleText("2020");
	driver.findElement(By.id("cc_cvv")).sendKeys("1212");
	
	driver.findElement(By.id("book_now")).click();

	Thread.sleep(5000);
	
	WebElement OrderConfirm = driver.findElement(By.xpath("//*[text()='Booking Confirmation ']"));
	String OrderConfirmationText = OrderConfirm.getText();
	
	
	WebElement userName = driver.findElement(By.xpath("//*[@id='username_show']"));
	String userNameText = userName.getAttribute("value");
	
	//System.out.println("The caught username text is: "+userNameText);
	
	softAssert.assertEquals(userNameText,"Hello saribshamim1!","Username is not correct !");
	
	softAssert.assertEquals(OrderConfirmationText,"Booking Confirmation","Booking confirmation is incorrect !");
	
	jse.executeScript("scroll(0, 900);");
	
	
	
	//String orderNum = driver.findElement(By.id("order_no")).getText();
	WebElement element = driver.findElement(By.xpath("//*[@id=\"order_no\"]"));
	String orderNum = element.getAttribute("value");

	Thread.sleep(4000);
	//driver.findElement(By.id("logout")).click();
	
	softAssert.assertAll();
	//System.out.println("Order caught value:"+OrderConfirmationText+".");
	
	System.out.println("--- Booking successfully generated ! Order num: "+orderNum+" --- browser name: "+browser);
	
	Thread.sleep(5000);
	
	//driver.quit();
	
}


}
