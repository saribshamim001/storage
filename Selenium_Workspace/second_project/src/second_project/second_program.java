package second_project;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class second_program {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver","C:\\LOCAL DRIVE D\\Selenium\\ChromeDriverVersion99\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		
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
		
		driver.findElement(By.xpath("")).sendKeys("");
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
		jse.executeScript("scroll(0, 900);");
		
		
		
		//String orderNum = driver.findElement(By.id("order_no")).getText();
		WebElement element = driver.findElement(By.xpath("//*[@id=\"order_no\"]"));
		String orderNum = element.getAttribute("value");

		Thread.sleep(4000);
		//driver.findElement(By.id("logout")).click();
		
		
		System.out.println("--- Booking successfully generated ! Order num: "+orderNum+" ---");
		
		Thread.sleep(5000);
		
		//driver.quit();
		
		
		
		
		/*
		//driver.findElement(By.xpath("  //input[  @value='Google Search' and  @name='btnK' and  @type ='submit'  and  @data-ved=\"0ahUKEwjB16uw_pP2AhWV3oUKHSOiC7wQ4dUDCAc\"  ]  ")).click();
		
		driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[3]/center/input[1]")).click();
		
		//Thread.sleep(50);
		
		driver.findElement(By.xpath("//*[text()='DHA Suffa University - Learn To Discover']")).click();
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,6000)");
		
		driver.findElement(By.xpath("//*[@id=\"apply-now\"]/div/div/div/div/section/div/div/a")).click();
		
		driver.get("https://mail.google.com/");
		driver.findElement(By.xpath("//input[@class=\"whsOnd zHQkBf\" and @jsname=\"YPqjbf\" and @id=\"identifierId\"]")).sendKeys("siddiqui00095@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button")).click();
		String title=driver.getTitle();
		
		System.out.println("The title is:  "+title);
		
		if(title.equalsIgnoreCase("Gmail")) {
			
			System.out.println("Test passed !");
			
		}
		
		else {
			
			System.out.println("Test is failed !");
			
		}
		driver.quit();
		*/
		
		
		
		
	}

}
