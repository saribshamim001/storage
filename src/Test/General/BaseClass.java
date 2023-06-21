package Test.General;

import POM.PageObject;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
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

    /*@BeforeMethod(groups = {"Inputter"})
    public void inputterLogin() {
//        edgeConfig();
        chromeConfig();
        PageObject.signIn("retail006", "QWer123456");
        //PageObject.signIn("SARA88", "QWer4321");

        PageObject.switchFrame(1);

        PageObject.menu_Dropdown("CSO - Conventional");
        PageObject.menu_Link("CSO - Conventional ");

        homePage = PageObject.switchToChildWindow();

        PageObject.maximizeWindow();
        PageObject.switchFrame(1);

    }*/

    @BeforeMethod(groups = {"CaoInputter2"})
    public void CaoInputterLogin2() {
//        edgeConfig();
        chromeConfig();
        PageObject.signIn("AB2375501", "QWer1234");
        PageObject.switchFrame(1);
        PageObject.menu_Dropdown("Centrlized Branch User Access");
        PageObject.menu_Link("Define Current Branch ");

        homePage = PageObject.switchToChildWindow();
        PageObject.textinput_Locator("transactionId","AB23755.01");
        PageObject.img_Button("Edit a contract");
        PageObject.textinput_Locator("fieldName:CURRENT.BRANCH","1003111030");
        PageObject.img_Button("Commit the deal");
        PageObject.img_Button("Commit the deal");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.close();
        PageObject.switchToParentWindow(homePage);
        PageObject.switchFrame(1);
    }

    @BeforeMethod(groups = {"CaoAuthorizer"})
    public void CaoAuthorizerLogin2() {
//        edgeConfig();
        chromeConfig();
        PageObject.signIn("NK1988001", "123456");
        PageObject.switchFrame(1);
    }

    /*@BeforeMethod(groups = {"CaoInputter2Auth"})
    public void CaoInputterLogin2Auth() {
//        edgeConfig();
        chromeConfig();
        PageObject.signIn("caoauth003", "QWer1234");
        PageObject.switchFrame(1);
        PageObject.menu_Dropdown("Centrlized Branch User Access Menu");
        PageObject.menu_Link("Define Current Branch ");

        homePage = PageObject.switchToChildWindow();
        PageObject.textinput_Locator("transactionId","CAOAUTH.003");
        PageObject.img_Button("Edit a contract");
        PageObject.textinput_Locator("fieldName:CURRENT.BRANCH","1002711030");
        PageObject.img_Button("Commit the deal");
        PageObject.img_Button("Commit the deal");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.close();
        PageObject.switchToParentWindow(homePage);
        PageObject.switchFrame(1);
    }*/


    /*@BeforeMethod(groups = {"CaoInputter"})
    public void CaoInputterLogin() {
//        edgeConfig();
        chromeConfig();
        PageObject.signIn("caouser001", "QWer1234");
        PageObject.switchFrame(1);
        PageObject.menu_Dropdown("Centrlized Branch User Access");
        driver.findElement(By.xpath("(//a[text()='Define Current Branch '])[2]")).click();
        homePage = PageObject.switchToChildWindow();
        PageObject.textinput_Locator("transactionId","CAOUSER.001");
        PageObject.img_Button("Edit a contract");
        PageObject.textinput_Locator("fieldName:CURRENT.BRANCH","100311100");
        PageObject.img_Button("Commit the deal");
        PageObject.img_Button("Commit the deal");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.close();
        PageObject.switchToParentWindow(homePage);
        PageObject.switchFrame(1);
    }*/

    /*@BeforeMethod(groups = {"InputterTDR"})

    public void InputterTDR() throws InterruptedException {
//        edgeConfig();
        chromeConfig();
        PageObject.signIn("AK2366601", "ADmin+258");

        PageObject.switchFrame(1);

        PageObject.menu_Dropdown("Centrlized Branch User Access Menu");
        PageObject.menu_Link("Define Current Branch ");

        homePage = PageObject.switchToChildWindow();

        PageObject.textinput_Locator("transactionId","AK23666.01");
        PageObject.img_Button("Edit a contract");


        PageObject.textinput_Locator("fieldName:CURRENT.BRANCH","1003111040");
        PageObject.img_Button("Commit the deal");
        PageObject.img_Button("Commit the deal");


        Thread.sleep(2000);
        driver.close();

        PageObject.switchToParentWindow(homePage);

//        PageObject.maximizeWindow();
        PageObject.switchFrame(1);

    }

    @BeforeMethod(groups = {"AuthorizerTDR"})

    public void AuthorizerTDR() throws InterruptedException {
//        edgeConfig();
        chromeConfig();
        PageObject.signIn("RB1965401", "ADmin+258");

        PageObject.switchFrame(1);

        PageObject.menu_Dropdown("Centrlized Branch User Access Menu");
        PageObject.menu_Link("Define Current Branch ");

        homePage = PageObject.switchToChildWindow();

        PageObject.textinput_Locator("transactionId","RB19654.01");
        PageObject.img_Button("Edit a contract");


        PageObject.textinput_Locator("fieldName:CURRENT.BRANCH","1003111040");
        PageObject.img_Button("Commit the deal");
        PageObject.img_Button("Commit the deal");


        Thread.sleep(5000);
        driver.close();

        PageObject.switchToParentWindow(homePage);

//        PageObject.maximizeWindow();
        PageObject.switchFrame(1);

    }*/


    @BeforeMethod(groups = {"InputterTDR_IBG"})

    public void InputterTDR_IBG() throws InterruptedException {
//        edgeConfig();
        chromeConfig();
        PageObject.signIn("AK2366602", "QWer12345");

        PageObject.switchFrame(1);

        PageObject.menu_Dropdown("Centrlized Branch User Access Menu");
        PageObject.menu_Link("Define Current Branch ");

        homePage = PageObject.switchToChildWindow();

        PageObject.textinput_Locator("transactionId","AK23666.02");
        PageObject.img_Button("Edit a contract");


        PageObject.textinput_Locator("fieldName:CURRENT.BRANCH","2550111030");
        PageObject.img_Button("Commit the deal");
        PageObject.img_Button("Commit the deal");


        Thread.sleep(5000);
        driver.close();

        PageObject.switchToParentWindow(homePage);

//        PageObject.maximizeWindow();
        PageObject.switchFrame(1);

    }

    /*@BeforeMethod(groups = {"AuthorizerTDR_IBG"})

    public void AuthorizerTDR_IBG() throws InterruptedException {
//        edgeConfig();
        chromeConfig();
        PageObject.signIn("RB1965401", "ADmin+258");

        PageObject.switchFrame(1);

        PageObject.menu_Dropdown("Centrlized Branch User Access Menu");
        PageObject.menu_Link("Define Current Branch ");

        homePage = PageObject.switchToChildWindow();

        PageObject.textinput_Locator("transactionId","RB19654.01");
        PageObject.img_Button("Edit a contract");


        PageObject.textinput_Locator("fieldName:CURRENT.BRANCH","1003111040");
        PageObject.img_Button("Commit the deal");
        PageObject.img_Button("Commit the deal");


        Thread.sleep(5000);
        driver.close();

        PageObject.switchToParentWindow(homePage);

//        PageObject.maximizeWindow();
        PageObject.switchFrame(1);

    }*/


    /*@BeforeMethod(groups = {"IBGInputter"})
    public void inputterIbgLogin() {
        chromeConfig();

        PageObject.signIn("retail001", "QWer1234");

        PageObject.switchFrame(1);

        PageObject.menu_Dropdown("CSO - IBG");
        PageObject.menu_Link("CSO - IBG ");

        homePage = PageObject.switchToChildWindow();

        PageObject.maximizeWindow();
        PageObject.switchFrame(1);

    }*/

    /*@BeforeMethod(groups = {"IBGAuthorizer"})
    public void authIbgLogin() {
        chromeConfig();

        PageObject.signIn("retailauth001", "QWer1234");

        homePage = driver.getWindowHandle();

        PageObject.switchFrame(1);

        PageObject.menu_Dropdown("IBG - Manager Operation Menu");
        PageObject.menu_Dropdown("Core Retail Menu");
    }*/


    /*@BeforeMethod(groups = {"Authorizer"})
    public void authorizerLogin() {
        chromeConfig();

        PageObject.signIn("retailauth006", "QWer1234");

        homePage = driver.getWindowHandle();

        PageObject.switchFrame(1);

        PageObject.menu_Dropdown("Manager Operation Menu");
        PageObject.menu_Dropdown("Core Retail Menu");

    }*/


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


//    @BeforeMethod(groups = {"PowerUser"})
//    public void PowerUserLogin() {
//        chromeConfig();
//
//        PageObject.signIn("talha01", "QWer1234");
//
//        homePage = driver.getWindowHandle();
//
//        PageObject.switchFrame(0);
//
//        driver.findElement(By.xpath("//div/div/form[@id='commandLineForm']")).clear();
//        driver.findElement(By.xpath("//div/div/form[@id='commandLineForm']")).sendKeys("RECORD.LOCK");
////        PageObject.textinput_Locator("commandValue","RECORD.LOCK");
//        PageObject.click_Locator("Go");
//
//        PageObject.maximizeWindow();
//        PageObject.switchFrame(0);
//    }

}




