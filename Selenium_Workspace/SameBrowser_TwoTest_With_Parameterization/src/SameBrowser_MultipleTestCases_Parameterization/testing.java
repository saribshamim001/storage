package SameBrowser_MultipleTestCases_Parameterization;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class testing {

	String driverPath = "C:\\LOCAL DRIVE D\\Selenium\\chromedriver_win32\\chromedriver.exe";
	WebDriver driver;
	
	SoftAssert softAssert = new SoftAssert();
	private static String locationText;
	private static String HotelsText;
	private static String Date_pick_inText;
	private static String Date_pick_outText;
	private static String firstNameText;
	private static String lastNameText;
	private static String billingAddressText;
	private static String CreditCardNoText;
	private static String CVVNumberText;
	private static String CreditCardTypeText;
	private static String ExpiryMonthText;
	private static String ExpiryYearText;
	
	
	
	@BeforeTest
	@Parameters({"location","Hotels","Date_pick_in", "Date_pick_out","firstName","lastName","billingAddress", "CreditCardNo", "CVVNumber" ,"CreditCardType", "ExpiryMonth","ExpiryYear"})
	public void setBrowserAndGetValues(String location, String Hotels, String Date_pick_in, String Date_pick_out, String firstName, String lastName, String billingAddress, String CreditCardNo, String CVVNumber, String CreditCardType, String ExpiryMonth, String ExpiryYear) {

        System.setProperty("webdriver.chrome.driver", driverPath);        
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        
        locationText =location;
        HotelsText = Hotels;
        Date_pick_inText=Date_pick_in;
        Date_pick_outText=Date_pick_out;
        firstNameText=firstName;
        lastNameText=lastName;
        billingAddressText=billingAddress;
        CreditCardNoText=CreditCardNo;
        CreditCardTypeText=CreditCardType;
        ExpiryMonthText=ExpiryMonth;
        ExpiryYearText=ExpiryYear;
        CVVNumberText=CVVNumber;
        
        driver.manage().window().maximize();
        
	
	}

	
	
	
	@Test
	public void openBrowser() throws InterruptedException {
		
		
		driver.get("https://adactinhotelapp.com/HotelAppBuild2/");
		
		driver.findElement(By.id("username")).sendKeys("saribshamim1");
		driver.findElement(By.id("password")).sendKeys("QWer12345");
		
		Thread.sleep(500);
		
		driver.findElement(By.className("login_button")).click();
		
		Select drpDownLocation = new Select(driver.findElement(By.id("location")));
		drpDownLocation.selectByVisibleText(locationText);
		
		Select drpDownRoomNos = new Select(driver.findElement(By.id("room_nos")));
		drpDownRoomNos.selectByIndex(8);
		
		WebElement datePickIn = driver.findElement(By.id("datepick_in"));
		//datePickIn.clear();
		
		
		datePickIn.sendKeys(Date_pick_inText);
		
		
		WebElement datePickOut = driver.findElement(By.id("datepick_out"));
		//datePickOut.clear();
		
		
		datePickOut.sendKeys(Date_pick_outText);
		
		//driver.findElement(By.id("datepick_in")).sendKeys(Date_pick_inText);
		//driver.findElement(By.id("datepick_out")).sendKeys(Date_pick_outText);
		
		//System.out.println("--------Date In:  "+Date_pick_inText+"---------");
		
		Select drpDownAdultsPerRoom = new Select(driver.findElement(By.id("adult_room")));
		drpDownAdultsPerRoom.selectByValue("3");
		
		
		Thread.sleep(5000);
		
		driver.findElement(By.id("Submit")).click();
		
		WebElement radioBtn = driver.findElement(By.id("radiobutton_4"));							
	            		
	    //Radio Button1 is selected		
	    radioBtn.click();
	    
	    Thread.sleep(5000);
	    
	    
	    
	    driver.findElement(By.id("continue")).click();
		
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,700)");
		
		driver.findElement(By.id("first_name")).sendKeys(firstNameText);
		driver.findElement(By.id("last_name")).sendKeys(lastNameText);
		driver.findElement(By.id("address")).sendKeys(billingAddressText);
		driver.findElement(By.id("cc_num")).sendKeys(CreditCardNoText);
		
		Select drpDownCC_Type = new Select(driver.findElement(By.id("cc_type")));
		drpDownCC_Type.selectByVisibleText(CreditCardTypeText);
		
		Select drpDownExp_Month = new Select(driver.findElement(By.id("cc_exp_month")));
		drpDownExp_Month.selectByVisibleText(ExpiryMonthText);
		
		Select drpDownExp_Year = new Select(driver.findElement(By.id("cc_exp_year")));
		drpDownExp_Year.selectByVisibleText(ExpiryYearText);
		
		
		driver.findElement(By.id("cc_cvv")).sendKeys(CVVNumberText);
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
		
		System.out.println("--- Booking successfully generated ! Order num: "+orderNum);
		
		Thread.sleep(5000);
		
		
}

	

}
