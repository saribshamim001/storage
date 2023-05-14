package TestDefinitions;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.cucumber.java.*;
import io.cucumber.java.en.*;

public class AdactinHotelReservationStepDefinitions {

	private ChromeDriver driver;

    @Before
    public void setup() {
    	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\Dependencies\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		driver.manage().window().maximize();
    }

    @Given("Browser and link is opened")
    public void browser_and_link_is_opened() {
        driver.get("https://adactinhotelapp.com/HotelAppBuild2/");
    }

    @When("I enter correct credentials")
    public void i_enter_correct_credentials() {
        
        String username = "Ahmed1234";
        String password = "abc1234";

        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.className("login_button")).click();
    }

    @Then("I must be logged to continue reservation")
    public void i_must_be_logged_to_continue_reservation() {
        Assert.assertTrue(driver.getTitle().matches("Adactin.com - Search Hotel"),"Invalid credentials");
        System.out.println("Login successful");
    }

    @Then("I will fill all the details")
    public void i_will_fill_all_the_details() throws InterruptedException {
        Select drpDownLocation = new Select(driver.findElement(By.id("location")));
        drpDownLocation.selectByVisibleText("Sydney");

        Select drpDownRoomNos = new Select(driver.findElement(By.id("room_nos")));
        drpDownRoomNos.selectByIndex(1);

        WebElement datePickIn = driver.findElement(By.xpath("//input[@name=\"datepick_in\"]"));
        datePickIn.click();
        datePickIn.clear();
        datePickIn.sendKeys("14/05/2023");

        WebElement datePickOut = driver.findElement(By.id("datepick_out"));
        datePickOut.click();
        datePickOut.clear();
        datePickOut.sendKeys("15/05/2023");

        Select drpDownAdultsPerRoom = new Select(driver.findElement(By.id("adult_room")));
        drpDownAdultsPerRoom.selectByIndex(1);

        driver.findElement(By.id("Submit")).click();

        WebElement radioBtn = driver.findElement(By.xpath("//input[@name=\"radiobutton_4\"]"));
        radioBtn.click();

        driver.findElement(By.id("continue")).click();

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,700)");

        driver.findElement(By.xpath("//input[@name=\"first_name\"]"))
            .sendKeys("John");

        driver.findElement(By.xpath("//input[@name=\"last_name\"]"))
            .sendKeys("Doe");

        driver.findElement(By.cssSelector("#address"))
            .sendKeys("123 Main St");

        driver.findElement(By.id("cc_num")).sendKeys("1234567890123456");

        Select drpDownCC_Type = new Select(driver.findElement(By.id("cc_type")));
        drpDownCC_Type.selectByIndex(1);
        
        Select drpDownExp_Month = new
				  Select(driver.findElement(By.id("cc_exp_month")));
				  
				  
				  drpDownExp_Month.selectByValue("2");
				  
				  
				  Select drpDownExp_Year = new
				  Select(driver.findElement(By.id("cc_exp_year")));
				  
				  drpDownExp_Year.selectByVisibleText("2022");
				  

				  driver.findElement(By.id("cc_cvv")).sendKeys("123");
				  
				  driver.findElement(By.id("book_now")).click();
				  
        
    }
    
    @Then("in the end order number must be generated")
    public void orderID_Mustbe_Generated() {
    	 
    	  JavascriptExecutor jse = (JavascriptExecutor) driver;  
    	
		  WebElement element = driver.findElement(By.cssSelector("#order_no")); String
		  
		  orderNum = element.getAttribute("value");
		  
		  jse = (JavascriptExecutor) driver;
		  
		  jse.executeScript("window.scrollBy(0,700)");
		 
		  
		  Assert.assertTrue(driver.getTitle().matches("Adactin.com - Hotel Booking Confirmation"),"Order not confirmed !");
		  
		  System.out.println("Order Successfully done ! Order ID: "+orderNum);
    }

    @Then("I will close the browser in end")
	public void i_will_close_the_browser() {
		driver.quit();
	}
    
}
