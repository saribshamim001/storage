package temp;

import java.util.Map;
import java.util.Optional;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v96.emulation.Emulation;

public class practise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println("?");
		
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		/*DevTools devTools = driver.getDevTools();
		devTools.createSession();
		devTools.send(Emulation.setGeolocationOverride(Optional.of(52.5043),
		                                               Optional.of(13.4501),
		                                               Optional.of(1)));
		driver.get("https://my-location.org/");
		*/
		
		Map coordinates = Map.of(
		        "latitude", 30.3079823,
		        "longitude", -97.893803,
		        "accuracy", 1
		);
		
		driver.manage().window().maximize();
		
		driver.executeCdpCommand("Emulation.setGeolocationOverride", coordinates);
		
		//Refresh if already on the page
		driver.navigate().refresh();

		//OR navigate to new URL
		driver.navigate().to("http://trueislam.com/");
		
		
	}

}
