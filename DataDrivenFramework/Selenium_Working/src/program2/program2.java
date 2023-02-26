package program2;


import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;




public class program2 {

	
	//private static final Object Object = null;
	ChromeDriver driver = new ChromeDriver();
	
	@BeforeTest
	public void beforeTest() {
		
		System.setProperty("webdriver.chrome.driver","E:\\Sarib\\Mywork\\Home\\Selenium\\chromedriver.exe");
		//System.setProperty("webdriver.chrome.driver", "Path of Chrome Driver");
		
		driver.manage().window().maximize();
		
	}
	
	@DataProvider
	public Iterator <Object[]> getTestData() {
		

		
		ReadExcelFile configuration = new ReadExcelFile("E:\\Sarib\\My work\\Home\\Selenium\\credentials.xlsx");
			
		ArrayList <Object[]> theArray = configuration.getData(0);
		
		
		return theArray.iterator();
	}
	
	
	@Test(dataProvider="getTestData")
	public void loginScript(String username,String password,String city, String DatePickIn, String DatePickOut,String name,String fname, String address, Double dnum, double month, double year, double secNum) throws InterruptedException {
		
		driver.get("https:	//adactinhotelapp.com/HotelAppBuild2/");	
		
		//System.out.println("Finally the data is: "+username+" "+password);
		
		
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);

		driver.findElement(By.className("login_button")).click();
		
		Assert.assertTrue(driver.getTitle().matches("Adactin.com - Search Hotel"),"Invalid credentials");
		
		System.out.println("Login successful");
		
		Thread.sleep(500);
		
		Select drpDownLocation = new Select(driver.findElement(By.id("location")));
		drpDownLocation.selectByVisibleText(city);

		Select drpDownRoomNos = new Select(driver.findElement(By.id("room_nos")));
		drpDownRoomNos.selectByIndex(1);

		WebElement datePickIn = driver.findElement(By.xpath("//input[@name=\"datepick_in\"]"));

		datePickIn.click();
		datePickIn.clear();
		datePickIn.sendKeys(DatePickIn);

		WebElement datePickOut = driver.findElement(By.id("datepick_out"));

		datePickOut.click();
		datePickOut.clear();
		datePickOut.sendKeys(DatePickOut);

		//
		  //#adult_room
		  
		  Select drpDownAdultsPerRoom = new
		  Select(driver.findElement(By.id("adult_room")));
		  drpDownAdultsPerRoom.selectByIndex(1);
		  
		  driver.findElement(By.id("Submit")).click();
		  
		  System.out.println("Form 1 Submitted successfully !");
		  
		  WebElement radioBtn =
				  driver.findElement(By.xpath("//input[@name=\"radiobutton_4\"]"));
				  
				  //Radio Button1 is selected 
				  
				  radioBtn.click();
				  
				  driver.findElement(By.id("continue")).click();
				  
				  Thread.sleep(500);
				  
				  
				  Thread.sleep(500);
				  
		System.out.println("Radio button selected");
		
		  JavascriptExecutor jse = (JavascriptExecutor) driver;
		  jse.executeScript("window.scrollBy(0,700)");
		  
		  
		  
		  driver.findElement(By.xpath("//input[@name=\"first_name\"]")).sendKeys(
				  name);
				 
				  driver.findElement(By.xpath("//input[@name=\"last_name\"]")).sendKeys(
				  fname);
				  
				  driver.findElement(By.cssSelector("#address")).
				  sendKeys(address);
				  
				  String dnum2=Double.toString(dnum);
				  driver.findElement(By.id("cc_num")).sendKeys(dnum2);
				  
				  
				  Select drpDownCC_Type = new Select(driver.findElement(By.id("cc_type")));
				  drpDownCC_Type.selectByIndex(1);
				  
				  
				  Select drpDownExp_Month = new
				  Select(driver.findElement(By.id("cc_exp_month")));
				  
//				  String month2=Double.toString(month);
				  
				  
				  DecimalFormat df = new DecimalFormat("#.#");
				  String month2 = df.format(month);
				  
				  drpDownExp_Month.selectByValue(month2);
				  
				  
				  Select drpDownExp_Year = new
				  Select(driver.findElement(By.id("cc_exp_year")));
//				  String year2=Double.toString(year);
				  
				  df = new DecimalFormat("####.#");
				  String year2 = df.format(year);

				  
				  drpDownExp_Year.selectByVisibleText(year2);
				  df = new DecimalFormat("####.#");
				  String secNum2 = df.format(secNum);

				  driver.findElement(By.id("cc_cvv")).sendKeys(secNum2);
				  
				  driver.findElement(By.id("book_now")).click();
				  
				  Thread.sleep(5000);
				  
				  
				  WebElement element = driver.findElement(By.cssSelector("#order_no")); String
				  
				  orderNum = element.getAttribute("value");
				  
				  jse = (JavascriptExecutor) driver;
				  
				  jse.executeScript("window.scrollBy(0,700)");
				 
				  
				  Assert.assertTrue(driver.getTitle().matches("Adactin.com - Hotel Booking Confirmation"),"Order not confirmed !");
				  
				  System.out.println("Order Successfully done ! Order ID: "+orderNum);
				  
				  //

	}
	
	@AfterTest
	void ProgramTermination() {
	
		driver.quit();
	
	}

}
