package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class base {
	
	public static WebDriver driver;
	public static Properties prop;
	
	
	
	public base() {
		
		prop = new Properties();
		
		try {
			FileInputStream ip = new FileInputStream("E:\\Sarib\\My work\\Home\\Eclipse workspace\\one\\src\\main\\java\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void initialization() {
		
		String browserName = prop.getProperty("browser");
		
		if (browserName.equalsIgnoreCase("chrome")) {
			
			System.setProperty("webdriver.chrome.driver","E:\\Sarib\\My work\\Home\\Selenium\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		/*
		 * else if (browserName.equalsIgnoreCase("firefox")) {
		 * 
		 * System.setProperty(
		 * "webdriver.gecko.driver","E:\\Sarib\\My work\\Home\\Selenium\\geckodriver.exe"
		 * ); driver = new FirefoxDriver(); }
		 */
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(utility.utilities.ImplicitTimeWait));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(utility.utilities.PageLoadTime));
		driver.get(prop.getProperty("url"));
		
		
	}
	

}
