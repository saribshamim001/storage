package daraz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class daraz {

	public static WebDriver driver;
	static List<Integer> integerlist;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println("?");
		
		String toSearch = "Men smartwatch" ;
		int ratingNum;
		int TopRatingCount=0;
		int count=1;
		integerlist = new ArrayList<>();
		
		//System.out.println(temp);
		
		
		System.setProperty("webdriver.chrome.driver","D:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		try {
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.get("http:\\www.daraz.pk");
		
		WebElement searchBox;
		WebElement searchButton;
		
		searchBox = driver.findElement(By.xpath("//input[ @class='search-box__input--O34g' ]"));
		searchButton = driver.findElement(By.xpath("//*[ text()='SEARCH' ]"));
		
		//Input values in search box
		searchBox.sendKeys(toSearch);
		
		//Enter search button
		searchButton.click();
		
		List<WebElement> listOfRatings = driver.findElements(By.xpath("//*[ @class='rating__review--ygkUy' ]"));
		
		
		//Traversing each rating item
		
		for (WebElement webElement : listOfRatings) {
            String ratingNumber = webElement.getText();
            ratingNumber = ratingNumber.replaceAll("[()]", "");
            
            //Converting to Integer
            ratingNum = Integer.parseInt(ratingNumber);

            
            //Printing that rating number to console
            System.out.println(ratingNum);

		
            //Adding that rating number to the integer list
            integerlist.add(ratingNum);
                
            //Counting count of ratingNumbers
            count = count +1;
		}
		
		Integer num = Collections.max(integerlist);
		int numPosition = integerlist.indexOf(Collections.max(integerlist));
		
		System.out.println("The hight rating of the product is:  "+num+", the Number position is:  "+numPosition+" Now closing browser and then opening that product again !");
		
	    String hightestRatingNum = String.valueOf(num);
	    
		driver.quit();
	    
		//xpath to catch: //*[contains(@class,'title--')]
		
		//Opening the browser again
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//Opening the link again
		driver.get("http:\\www.daraz.pk");
		
		List<WebElement> allClassesofProducts = driver.findElements(By.xpath("//*[ @class='gridItem--Yd0sa' ]"));
		searchBox = driver.findElement(By.xpath("//input[ @class='search-box__input--O34g' ]"));
		searchButton = driver.findElement(By.xpath("//*[ text()='SEARCH' ]"));
		
		//Input values in search box
		searchBox.sendKeys(toSearch);
		
		//Enter search button
		searchButton.click();
		
		
		//Storing WebElements
		List<WebElement> listOfRatingsAgain = driver.findElements(By.xpath("//*[ @class='rating__review--ygkUy' ]"));
		List<WebElement> listOfWatches = driver.findElements(By.xpath("//*[ @class=\"gridItem--Yd0sa\" ]"));
		
		
		
		//Traversing each rating item to perform click 
		
		/*for (WebElement webElement : listOfRatingsAgain) {
            String ratingNumber = webElement.getText();
            if (ratingNumber.equalsIgnoreCase(hightestRatingNum)) {
            	//Perform click to that item !
            }
		}*/
		
		count=0;
		for (WebElement webElement : allClassesofProducts) {
            
			if (count==numPosition) {
				//*[@attribute_name1='attribute_value1' and @attribute_name2='attribute_value2]
				//WebElement addItem = driver.findElement(By.xpath("//td[@class='action' and .//td[@class='caption']/a[. = 'Foo Bar']]/following-sibling::td[contains(@class, 'rule')]//td[@class='plus']/img[@title='Add item']"));
				//addItem.click();
				//https://stackoverflow.com/questions/29417987/finding-webelement-relative-to-another-webelement
			}
		}
		
		
	    
	    System.out.println("\n\nEND hogya ji ... !");
		
		
	}

}
