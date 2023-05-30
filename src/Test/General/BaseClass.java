package Test.General;

import POM.PageObject;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

public class BaseClass {

    public static WebDriver driver;
    public static Actions action;
    public static String homePage;

    // Configuration Property File
    public String getProperty(String key) throws IOException {
        //Reading configuration file from the path

        FileReader reader = new FileReader(System.getProperty("user.dir") + "\\src\\Resources\\config.properties");
        Properties props = new Properties();
        props.load(reader);
        return props.getProperty(key);
    }

    // Configuration Of Chrome Driver
    public void chromeConfig() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\dependency\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);

        this.driver = new ChromeDriver(options);

        PageObject PageObject = new PageObject(driver);

        action = new Actions(driver);

        driver.get("https://172.24.128.50/R22SIT2/servlet/BrowserServlet");
        //driver.get("http://172.21.81.59:9080/R13UAT1/servlet/BrowserServlet");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    // Configuration Of Edge Driver
    public static void edgeConfig() {
        System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "\\dependency\\msedgedriver.exe");

        EdgeOptions options = new EdgeOptions();
        options.setAcceptInsecureCerts(true);

        driver = new EdgeDriver(options);

        PageObject PageObject = new PageObject(driver);

        action = new Actions(driver);

        driver.get("https://172.24.128.50/R22SIT2/servlet/BrowserServlet");
        //driver.get("http://172.21.81.59:9080/R13UAT1/servlet/BrowserServlet");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    //    Screenshot Utility
    public String getScreenshot(String testCaseName) throws IOException {

        TakesScreenshot sc = (TakesScreenshot) driver;
        File path = sc.getScreenshotAs(OutputType.FILE);
        File file = new File(System.getProperty("user.dir") + "\\Reports\\" + testCaseName + ".png");
//        File file = new File("C:\\Users\\xcelliti2\\IdeaProjects\\Retail Ops\\Reports\\" +testCaseName+ ".png");
        FileUtils.copyFile(path, file);
        return System.getProperty("user.dir") + "\\Reports\\" + testCaseName + ".png";
    }

    public static String AssertionScreenshot(String testCaseName) throws IOException {

        Date date1 = new Date();
        SimpleDateFormat dft = new SimpleDateFormat("E yyyy.MM.dd HH:mm:ss");
        String replaceString=dft.format(date1).toString().replaceAll(":"," ");
        TakesScreenshot sc = (TakesScreenshot) driver;
        File path = sc.getScreenshotAs(OutputType.FILE);
        File file = new File(System.getProperty("user.dir") + "\\"+ testCaseName+ "\\" + testCaseName + replaceString +".png");
        FileUtils.copyFile(path, file);
        return System.getProperty("user.dir") + "\\"+ testCaseName+ "\\" + testCaseName + dft.format(date1) +".png";
    }

    @BeforeMethod(groups = {"Inputter"})
    public void inputterLogin() {
//        edgeConfig();
        chromeConfig();
        PageObject.signIn("RETAIL888", "QWer1234");
        //PageObject.signIn("SARA88", "QWer4321");

        PageObject.switchFrame(1);

        PageObject.menu_Dropdown("CSO - Conventional");
        PageObject.menu_Link("CSO - Conventional ");

        homePage = PageObject.switchToChildWindow();

        PageObject.maximizeWindow();
        PageObject.switchFrame(1);

    }
    @BeforeMethod(groups = {"IBGInputter"})
    public void inputterIbgLogin() {
        chromeConfig();

        PageObject.signIn("retail001", "QWer1234");

        PageObject.switchFrame(1);

        PageObject.menu_Dropdown("CSO - IBG");
        PageObject.menu_Link("CSO - IBG ");

        homePage = PageObject.switchToChildWindow();

        PageObject.maximizeWindow();
        PageObject.switchFrame(1);

    }

    @BeforeMethod(groups = {"IBGAuthorizer"})
    public void authIbgLogin() {
        chromeConfig();

        PageObject.signIn("retailauth001", "QWer1234");

        homePage = driver.getWindowHandle();

        PageObject.switchFrame(1);

        PageObject.menu_Dropdown("IBG - Manager Operation Menu");
        PageObject.menu_Dropdown("Core Retail Menu");
    }


    @BeforeMethod(groups = {"Authorizer"})
    public void authorizerLogin() {
        chromeConfig();

        PageObject.signIn("retailauth006", "QWer1234");

        homePage = driver.getWindowHandle();

        PageObject.switchFrame(1);

        PageObject.menu_Dropdown("Manager Operation Menu");
        PageObject.menu_Dropdown("Core Retail Menu");
    }


//    @AfterMethod(groups = {"Authorizer" , "Inputter", "IBGInputter", "IBGAuthorizer"})
//    public void userLogout(){
//        this.driver.close();
//
//        PageObject.switchToParentWindow(homePage);
//
//        PageObject.switchFrame(0);
//
//        PageObject.signOff();
//
//        this.driver.close();
//    }

}




