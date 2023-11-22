package grid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class grid {

	public static WebDriver driver;
	public static String nodeURL;
	
	public static void main(String[] args) throws MalformedURLException {
		
		nodeURL="http://192.168.1.184:5555/wd/hub";
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--window-position=0,0");
		options.addArguments("--window-size=1840,1080");
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-gpu");
		options.addArguments("--headless");
		driver = new RemoteWebDriver(new URL(nodeURL), options);
		
		/*
		try {
			
			
			
			System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
			
			//Now you can Initialize marionette driver to launch firefox
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability("marionette", true);
			capabilities.setCapability("chrome","VISTA");
			driver = new RemoteWebDriver(new URL(nodeURL),capabilities);
			
						
			
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		
		
	}

}
