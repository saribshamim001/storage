package second_program_edureka_course;

import org.openqa.selenium.chrome.ChromeDriver;

public class second_program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Kia scene he ?????");
		
		System.setProperty("webdriver.chrome.driver","C:\\LOCAL DRIVE D\\Selenium\\latestChromeDriver\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		
		driver.get("https://www.amazon.com");
		driver.close();
	
	}

}
