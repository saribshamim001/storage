package first_program;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class first_prog {

	static JavascriptExecutor jse;
	
	public static void main(String[] args) throws InterruptedException, AWTException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://lms.dsu.edu.pk");
		//driver.findElement(By.cssSelector("#identifierId")).sendKeys("TestSelenium1607@gmail.com");
		//driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button/span")).click();
		
		Robot robot =new Robot();
		
		//Enter Credentials
		robot.keyPress(KeyEvent.VK_C);
		robot.keyRelease(KeyEvent.VK_C);
		
		robot.keyPress(KeyEvent.VK_S);
		robot.keyRelease(KeyEvent.VK_S);
		
		
		robot.keyPress(KeyEvent.VK_1);
		robot.keyRelease(KeyEvent.VK_1);
		
		robot.keyPress(KeyEvent.VK_5);
		robot.keyRelease(KeyEvent.VK_5);
		
		
		robot.keyPress(KeyEvent.VK_2);
		robot.keyRelease(KeyEvent.VK_2);
		
		
		robot.keyPress(KeyEvent.VK_0);
		robot.keyRelease(KeyEvent.VK_0);
		
		
		robot.keyPress(KeyEvent.VK_4);
		robot.keyRelease(KeyEvent.VK_4);
		
		
		robot.keyPress(KeyEvent.VK_6);
		robot.keyRelease(KeyEvent.VK_6);
		
		
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		
		
		robot.keyPress(KeyEvent.VK_S);
		robot.keyRelease(KeyEvent.VK_S);
		
		
		robot.keyPress(KeyEvent.VK_A);
		robot.keyRelease(KeyEvent.VK_A);
		
		
		robot.keyPress(KeyEvent.VK_R);
		robot.keyRelease(KeyEvent.VK_R);
		
		
		robot.keyPress(KeyEvent.VK_I);
		robot.keyRelease(KeyEvent.VK_I);
		
		
		robot.keyPress(KeyEvent.VK_B);
		robot.keyRelease(KeyEvent.VK_B);
		
		
		robot.keyPress(KeyEvent.VK_S);
		robot.keyRelease(KeyEvent.VK_S);
		
		
		robot.keyPress(KeyEvent.VK_H);
		robot.keyRelease(KeyEvent.VK_H);
		
		
		robot.keyPress(KeyEvent.VK_A);
		robot.keyRelease(KeyEvent.VK_A);
		
		
		robot.keyPress(KeyEvent.VK_M);
		robot.keyRelease(KeyEvent.VK_M);
		
		
		robot.keyPress(KeyEvent.VK_I);
		robot.keyRelease(KeyEvent.VK_I);
		
		
		robot.keyPress(KeyEvent.VK_M);
		robot.keyRelease(KeyEvent.VK_M);
		
		
		robot.keyPress(KeyEvent.VK_0);
		robot.keyRelease(KeyEvent.VK_0);
		
		
		robot.keyPress(KeyEvent.VK_0);
		robot.keyRelease(KeyEvent.VK_0);
		
		//Press Enter
		robot.keyPress(KeyEvent.VK_1);
		robot.keyRelease(KeyEvent.VK_1);
		
		Thread.sleep(2000);
		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		Thread.sleep(2000);
		
		//Click Login
		driver.findElement(By.xpath("//*[@id=\"page-site-index\"]/nav/ul[2]/li[2]/div/a")).click();
		
		//Enter Credentials
		driver.findElement(By.cssSelector("#username")).sendKeys("cs152046");
		driver.findElement(By.cssSelector("#password")).sendKeys("saribshamim001");
		
		//Click loginButton
		driver.findElement(By.xpath("//*[ @type='submit' and @class='btn btn-primary' ]")).click();
		
		Thread.sleep(2000);
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,500)");
		
		//WebElement dropDownList = driver.findElement(By.xpath(" //*[ @id='displaydropdown' ]"));
		//dropDownList.click();
		
		
		//List<WebElement> options = driver.findElements(By.);
		//options.get(1).click();
		
		//Select dropDown = new Select (driver.findElement(By.xpath("//*[ @class='dropdown mb-1' ]")));
		//List<WebElement> e = dropDown.getOptions();
		//int itemsCount = e.size();
		
		
		WebElement selectMyElement = driver.findElement(By.xpath("//*[ @class='dropdown mb-1' ]")); 
		selectMyElement.click();

		Actions keyDown = new Actions(driver);
		keyDown.sendKeys(Keys.chord(Keys.DOWN,Keys.DOWN,Keys.DOWN,Keys.ENTER)).perform();
		
		Thread.sleep(2000);
		
		WebElement selectMyElement2 = driver.findElement(By.xpath(" //*[ @class='mb-1 mr-1 d-flex align-items-center' ] "));
		selectMyElement2.click();
		
		
		Actions keyDown2 = new Actions(driver);
		keyDown2.sendKeys(Keys.chord(Keys.DOWN,Keys.DOWN,Keys.ENTER)).perform();
		
		
		Thread.sleep(1000);
		
		
		/*
		 
		// enter a valid password
		driver.findElement(By.id("Passwd")).sendKeys("TestSelenium");
		 
		// click on sign in button
		
		Thread.sleep(30000);
		 
		// click on compose button
		driver.findElement(By.xpath("//div[@class='z0']//div[contains(text(),'COMPOSE')]")).click();
		 
		// click on attach files icon
		driver.findElement(By.xpath("//div[contains(@command,'Files')]//div[contains(@class,'aaA')]")).click();
		 
		// creating instance of Robot class (A java based utility)
		
		 
		// pressing keys with the help of keyPress and keyRelease events
		rb.keyPress(KeyEvent.VK_D);
		rb.keyRelease(KeyEvent.VK_D);
		Thread.sleep(2000);
		 
		rb.keyPress(KeyEvent.VK_SHIFT);
		rb.keyPress(KeyEvent.VK_SEMICOLON);
		rb.keyRelease(KeyEvent.VK_SEMICOLON);
		rb.keyRelease(KeyEvent.VK_SHIFT);
		 
		rb.keyPress(KeyEvent.VK_BACK_SLASH);
		rb.keyRelease(KeyEvent.VK_BACK_SLASH);
		Thread.sleep(2000);
		 
		rb.keyPress(KeyEvent.VK_P);
		rb.keyRelease(KeyEvent.VK_P);
		 
		rb.keyPress(KeyEvent.VK_I);
		rb.keyRelease(KeyEvent.VK_I);
		 
		rb.keyPress(KeyEvent.VK_C);
		rb.keyRelease(KeyEvent.VK_C);
		Thread.sleep(2000);
		 
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		//Robot robot = new Robot();
		
		//robot.keyPress("ss");
		
		//Actions builder = new Actions(driver);
		
		//builder.moveToElement(driver.findElement(By.linkText("Categories"))).build().perform();
		
		//WebElement textBox = driver.findElement(By.cssSelector("#email"));
		
		//Action seriesOfAction = builder.moveToElement(textBox).click().keyDown(textBox,Keys.SHIFT).sendKeys(textBox,"abcdefghijklmnopqrstuvxyz").keyUp(textBox,Keys.SHIFT).doubleClick(textBox).contextClick().build();
		
		//seriesOfAction.perform();
		
		//builder.sendKeys("abcdefghijklmnopqrstuvxyz");
		//builder.keyDown(textBox,Keys.SHIFT).sendKeys(textBox, "abcdefghijklmnopqrstuvxyz").build().perform();		
		//builder.doubleClick(textBox).build().perform();
		//builder.contextClick().build().perform();
		//WebElement element = driver.findElement(By.id("text"));
		// assuming driver is a well behaving WebDriver
		//Actions actions = new Actions(driver);
		// and some variation of this:
		//builder.moveToElement(textBox).click().perform();
		//textBox.click();
		//builder.sendKeys(Keys.CONTROL+"a");
		//action.keyDown(element,Keys.SHIFT).sendKeys("lambdatest").build().perform();
		
		//driver.switchTo().frame(0);
		//WebElement item = driver.findElement(By.xpath("//*[@id='draggable']"));
		//WebElement targetLocation = driver.findElement(By.xpath("//*[@id='droppable']"));
		
		//builder.dragAndDrop(item, targetLocation).build().perform();
		//builder.clickAndHold(item).moveToElement(targetLocation).release().build().perform();
		
		*/
		//driver.quit();
		System.out.println("Test Ended !");
		/*
		driver.get("https://www.amazon.com");
		//driver.findElement(By.cssSelector("#nav-xshop > a:nth-child(3)")).click();
		//driver.findElement(By.cssSelector("#u472-search-form-autocomplete--3")).sendKeys("Java");
		//driver.findElement(By.xpath("//*[@id=\"udemy\"]/div[2]/div[1]/div[3]/div[2]/form/button")).click();
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Guitar");
		driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
		jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,1000)");
		driver.findElement(By.xpath("//*[@id=\"p_n_style_browse-bin/5506299011\"]/span/a/div/label/i")).click();
		
		
		//String title=driver.getTitle();
		
		//String theUrl=driver.getCurrentUrl();
		
		//driver.quit();
		
		//driver.navigate().back();
		//driver.navigate().forward();
		//Thread.sleep(2000);
		System.out.println("The End of test !!!!!!!!");
	//	driver.quit();
	*/
		
	
	}
	
	

}
