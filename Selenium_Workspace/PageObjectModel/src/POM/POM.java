package POM;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class POM {

	public static WebDriver driver;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String driverPath = "C:\\LOCAL DRIVE D\\Selenium\\chromedriver_win32\\chromedriver.exe";
		
		System.setProperty("webdriver.chrome.driver", driverPath);        
        driver = new ChromeDriver();
        
	}

}