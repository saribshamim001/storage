package Test.General;

import POM.PageObject;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.*;
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

        driver.get("http://172.24.157.16:9080/ENV/servlet/BrowserServlet");
//        driver.get("https://172.24.128.50/R22UAT1/servlet/BrowserServlet");
//        driver.get("http://172.24.157.27:9080/R22SIT2/servlet/BrowserServlet");
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

        driver.get("http://172.24.157.27:9080/R22SIT2/servlet/BrowserServlet");
        //driver.get("http://172.21.81.59:9080/R13UAT1/servlet/BrowserServlet");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    //    Screenshot Utility
    public String getScreenshot(String testCaseName) throws IOException {

        TakesScreenshot sc = (TakesScreenshot) driver;
        File path = sc.getScreenshotAs(OutputType.FILE);
        File file = new File(System.getProperty("user.dir") + "\\Reports\\" + testCaseName + " " + PageObject.idNumber() +".png");
//        File file = new File("C:\\Users\\xcelliti2\\IdeaProjects\\Retail Ops\\Reports\\" +testCaseName+ ".png");
        FileUtils.copyFile(path, file);
        return System.getProperty("user.dir") + "\\Reports\\" + testCaseName + " " + PageObject.idNumber() +".png";
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

    @BeforeMethod(groups = {"InputterTDR"})

    public void InputterTDR() throws InterruptedException {
//        edgeConfig();
        chromeConfig();
        PageObject.signIn("AK2366601", "");

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

    }

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

    @BeforeMethod(groups = {"AuthorizerTDR_IBG"})

    public void AuthorizerTDR_IBG() throws InterruptedException {
//        edgeConfig();
        chromeConfig();
//        PageObject.signIn("RB1965401", "ADmin+258");
        PageObject.signIn("RB1965402", "QWer1234");

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

    }


    @BeforeMethod(groups = {"CfrInputter"})
    public void CfrInputter() throws InterruptedException {
        chromeConfig();
        PageObject.signIn("cfr01", "QWer1234");

        PageObject.switchFrame(1);

        PageObject.menu_Dropdown("Centrlized Branch User Access");
        PageObject.menu_Link("Define Current Branch ");

        homePage = PageObject.switchToChildWindow();

        PageObject.textinput_Locator("transactionId","CFR.01");
        PageObject.img_Button("Edit a contract");


        PageObject.textinput_Locator("fieldName:CURRENT.BRANCH","1001911540");
        PageObject.img_Button("Commit the deal");
        PageObject.img_Button("Commit the deal");


        Thread.sleep(5000);
        driver.close();

        PageObject.switchToParentWindow(homePage);

//        PageObject.maximizeWindow();
        driver.switchTo().parentFrame();
        PageObject.switchFrame(1);
    }

    @BeforeMethod(groups = {"CfrAuthorizer"})
    public void CfrAuthorizer() throws InterruptedException {
        chromeConfig();
        PageObject.signIn("cfr02", "QWer1234");
        //PageObject.signIn("SARA88", "QWer4321");

        PageObject.switchFrame(1);


    }

    @BeforeMethod(groups = {"IBG_CfrInputter"})
    public void IBG_CfrInputter() throws InterruptedException {
        chromeConfig();
        PageObject.signIn("AB2375501", "QWer12345");

        PageObject.switchFrame(0);
        PageObject.tools();
        PageObject.switchToChildWindow();
        PageObject.menu_Dropdown("My Companies");
        PageObject.menu_Link("BANK ALFALAH LTD - IBG ");
        PageObject.switchToChildWindow();

        PageObject.parentFrame();
        PageObject.switchFrame(1);

        PageObject.menu_Dropdown("Centrlized Branch User Access");
        PageObject.menu_Link("Define Current Branch ");

        homePage = PageObject.switchToChildWindow();

        PageObject.textinput_Locator("transactionId","AB23755.01");
        PageObject.img_Button("Edit a contract");


        PageObject.textinput_Locator("fieldName:CURRENT.BRANCH","1556111040");
        PageObject.img_Button("Commit the deal");
        PageObject.img_Button("Commit the deal");


        Thread.sleep(5000);
        driver.close();

        PageObject.switchToParentWindow(homePage);

//        PageObject.maximizeWindow();
        driver.switchTo().parentFrame();
        PageObject.switchFrame(1);
    }

    @BeforeMethod(groups = {"IBG_CfrAuthorizer"})
    public void IBG_CfrAuthorizer() throws InterruptedException {
        chromeConfig();
        PageObject.signIn("cfr04", "QWer1234");
        //PageObject.signIn("SARA88", "QWer4321");

        PageObject.switchFrame(1);


    }



    @BeforeMethod(groups = {"InputterNewEnv"})
    public void inputterLogin2() throws InterruptedException, AWTException {
//        edgeConfig();
        chromeConfig();
        PageObject.signIn("retail01","QWer1234");
        //PageObject.signIn("SARA88", "QWer4321");

        PageObject.switchFrame(1);

        PageObject.menu_DropdownEnv("CSO - Conventional");
        PageObject.menu_LinkEnv("CSO - Conventional ");

        //        PageObject.menu_Dropdown("CSO - Conventional");
//        PageObject.menu_Link("CSO - Conventional ");

        homePage = PageObject.switchToChildWindow();

        PageObject.maximizeWindow();
        PageObject.switchFrame(1);

    }

    @BeforeMethod(groups = {"Inputter"})
    public void inputterLogin() throws InterruptedException, AWTException {
//        edgeConfig();
        chromeConfig();
        PageObject.signIn("retail006","QWer1234");
        //PageObject.signIn("SARA88", "QWer4321");
        Thread.sleep(1000);
        Robot robot = new Robot();  // Robot class throws AWT Exception
        robot.keyPress(KeyEvent.VK_ENTER);  // press arrow down key of keyboard to navigate and select Save radio button
        Thread.sleep(500);
        robot.keyRelease(KeyEvent.VK_ENTER);  // press arrow down key of keyboard to navigate and select Save radio button


        PageObject.switchFrame(1);

        PageObject.menu_Dropdown("CSO - Conventional");
        PageObject.menu_Link("CSO - Conventional ");

        homePage = PageObject.switchToChildWindow();

        PageObject.maximizeWindow();
        PageObject.switchFrame(1);

    }
    @BeforeMethod(groups = {"CaoInputterCentralized"})
    public void CaoInputCentralizedLogin() {
//        edgeConfig();
        chromeConfig();
        //
        PageObject.signIn("caouser006", "QWer1234"); //jk881201 aa2749301 AA2749301 JK881201 AB2375501
        PageObject.switchFrame(1);
        PageObject.menu_Dropdown("Centrlized Branch User Access");
        PageObject.childmenu_Link("Define Current Branch ",2);

        homePage = PageObject.switchToChildWindow();
        PageObject.textinput_Locator("transactionId","CAOUSER.006");
        PageObject.img_Button("Edit a contract");
        PageObject.textinput_Locator("fieldName:CURRENT.BRANCH","1003111040");  // Department Code: 1099411043
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

    @BeforeMethod(groups = {"CaoInputter"})
    public void CaoInputterLogin2() {
//        edgeConfig();
        chromeConfig();
        //
        PageObject.signIn("caouser002", "QWer1234"); //jk881201 aa2749301 AA2749301 JK881201 AB2375501
        PageObject.switchFrame(1);
        PageObject.menu_Dropdown("Centrlized Branch User Access");
        PageObject.childmenu_Link("Define Current Branch ",2);

        homePage = PageObject.switchToChildWindow();
        PageObject.textinput_Locator("transactionId","CAOUSER.002");
        PageObject.img_Button("Edit a contract");
        PageObject.textinput_Locator("fieldName:CURRENT.BRANCH","1003111040");
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
    @BeforeMethod(groups = {"CaoAuthorizer1"})
    public void caoAuthorizer1() {
//        edgeConfig();
        chromeConfig();
        PageObject.signIn("caoauth002", "QWer1234");
        PageObject.switchFrame(1);

    }

    @BeforeMethod(groups = {"CaoStandingInputter"})
    public void CaoInputterLogin3() {
//        edgeConfig();
        chromeConfig();
        //
        PageObject.signIn("caouser003", ""); //jk881201 aa2749301 AA2749301 JK881201 AB2375501
        PageObject.switchFrame(1);
        PageObject.menu_Dropdown("Centrlized Branch User Access Menu");
        PageObject.childmenu_Link("Define Current Branch ",1);

        homePage = PageObject.switchToChildWindow();
        PageObject.textinput_Locator("transactionId","CAOUSER.003");
        PageObject.img_Button("Edit a contract");
        PageObject.textinput_Locator("fieldName:CURRENT.BRANCH","1003111040");
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

    @BeforeMethod(groups = {"CaoStandingInputterIBG"})
    public void CaoInputterLogin4() {
//        edgeConfig();
        chromeConfig();
        //
        PageObject.signIn("caouser003", ""); //jk881201 aa2749301 AA2749301 JK881201 AB2375501
//        PageObject.switchFrame(1);

        PageObject.switchFrame(0);
        driver.findElement(By.xpath("//a[text()='Tools']")).click();
        String mainPage = PageObject.switchToChildWindow();
        driver.findElement(By.xpath("//img[@alt='My Companies']")).click();
        driver.findElement(By.xpath("//*[text()='BANK ALFALAH LTD - IBG ']")).click();
        PageObject.switchToChildWindow();
        PageObject.switchFrame(1);
        PageObject.menu_Dropdown("Centrlized Branch User Access Menu");
        PageObject.childmenu_Link("Define Current Branch ",1);
        homePage = PageObject.switchToChildWindow();
        PageObject.textinput_Locator("transactionId","CAOUSER.003");
        PageObject.img_Button("Edit a contract");
//        PageObject.textinput_Locator("fieldName:CURRENT.BRANCH","100311100");
        PageObject.textinput_Locator("fieldName:CURRENT.BRANCH","1556111040");

//        PageObject.menu_Dropdown("Centrlized Branch User Access Menu");
//        PageObject.childmenu_Link("Define Current Branch ",1);

//        homePage = PageObject.switchToChildWindow();
//        PageObject.textinput_Locator("transactionId","CAOUSER.003");
//        PageObject.img_Button("Edit a contract");
//        PageObject.textinput_Locator("fieldName:CURRENT.BRANCH","1003111040");

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
    @BeforeMethod(groups = {"CaoStandingAuthorizer"})
    public void caoStandAuthorizerLogin() {
//        edgeConfig();
        chromeConfig();
        PageObject.signIn("caoauth003", "QWer1234");
        PageObject.switchFrame(1);

    }
    @BeforeMethod(groups = {"CaoStandingAuthorizerIBG"})
    public void caoStandAuthorizerIBG() {
//        edgeConfig();
        chromeConfig();
        PageObject.signIn("caoauth003", "QWer1234");
        PageObject.switchFrame(1);

//        PageObject.switchFrame(0);
        driver.findElement(By.xpath("//a[text()='Tools']")).click();
        String mainPage = PageObject.switchToChildWindow();
        driver.findElement(By.xpath("//img[@alt='My Companies']")).click();
        driver.findElement(By.xpath("//*[text()='BANK ALFALAH LTD - IBG ']")).click();
        PageObject.switchToChildWindow();
        PageObject.switchFrame(1);
    }
    @BeforeMethod(groups = {"CaoClearInputter"})
    public void ClearingInputter() {
//        edgeConfig();
        chromeConfig();
        //
        PageObject.signIn("AB2375501", "QWer12345"); //jk881201 aa2749301 AA2749301 JK881201 AB2375501
        PageObject.switchFrame(1);
        PageObject.menu_Dropdown("Centrlized Branch User Access");
        PageObject.childmenu_Link("Define Current Branch ",1);

        homePage = PageObject.switchToChildWindow();
        PageObject.textinput_Locator("transactionId","AB23755.01");
        PageObject.img_Button("Edit a contract");
        PageObject.textinput_Locator("fieldName:CURRENT.BRANCH","1003111040");
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
    public void caoAuthorizerLogin() {
//        edgeConfig();
        chromeConfig();
        PageObject.signIn("NK1988001", "123456");
        PageObject.switchFrame(1);

    }


    @BeforeMethod(groups = {"CaoInputterIBG"})
    public void CaoInputterLoginIBG() {
//        edgeConfig();
        chromeConfig();
        PageObject.signIn("caouser006", "QWer1234");
//        PageObject.switchFrame(0);
//        driver.findElement(By.xpath("//a[text()='Tools']")).click();
//        String mainPage = PageObject.switchToChildWindow();
//        driver.findElement(By.xpath("//img[@alt='My Companies']")).click();
//        driver.findElement(By.xpath("//*[text()='BANK ALFALAH LTD - IBG ']")).click();
//        PageObject.switchToChildWindow();
        PageObject.switchFrame(1);
        PageObject.menu_Dropdown("Centrlized Branch User Access");
        PageObject.childmenu_Link("Define Current Branch ",2);
        homePage = PageObject.switchToChildWindow();
        PageObject.textinput_Locator("transactionId","CAOUSER.006");
        PageObject.img_Button("Edit a contract");
//        PageObject.textinput_Locator("fieldName:CURRENT.BRANCH","100311100");
        PageObject.textinput_Locator("fieldName:CURRENT.BRANCH","1556111040");
//        driver.findElement(By.xpath("//input[@id='fieldName:CURRENT.BRANCH']")).sendKeys(Keys.ENTER);
        PageObject.img_Button("Commit the deal");
        PageObject.img_Button("Commit the deal");

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.close();
        PageObject.switchToParentWindow(homePage);
        PageObject.switchFrame(1);
    }

    @BeforeMethod(groups = {"CaoAuthorizerIbg"})
    public void CaoIbgAuthLogin() {
//        edgeConfig();
        chromeConfig();
        PageObject.signIn("caoauth002", "QWer1234");
        PageObject.switchFrame(0);
        driver.findElement(By.xpath("//a[text()='Tools']")).click();
        String mainPage = PageObject.switchToChildWindow();
        driver.findElement(By.xpath("//img[@alt='My Companies']")).click();
        driver.findElement(By.xpath("//*[text()='BANK ALFALAH LTD - IBG ']")).click();
        PageObject.switchToChildWindow();
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
    public void authorizerLogin() throws AWTException, InterruptedException {
        chromeConfig();

        PageObject.signIn("retailauth006", "QWer1234");
        Thread.sleep(1000);

        Robot robot = new Robot();  // Robot class throws AWT Exception
        robot.keyPress(KeyEvent.VK_ENTER);  // press arrow down key of keyboard to navigate and select Save radio button
        Thread.sleep(500);
        robot.keyRelease(KeyEvent.VK_ENTER);

        homePage = driver.getWindowHandle();

        PageObject.switchFrame(1);

        PageObject.menu_Dropdown("Manager Operation Menu");
        PageObject.menu_Dropdown("Core Retail Menu");

    }


    @BeforeMethod(groups = {"AuthorizerNewEnv"})
    public void authorizerLogin2() throws AWTException, InterruptedException {
        chromeConfig();

        PageObject.signIn("retailauth01", "QWer1234");

        homePage = driver.getWindowHandle();

        PageObject.switchFrame(1);

        PageObject.menu_DropdownEnv("Manager Operation Menu");
        PageObject.menu_DropdownEnv("Core Retail Menu");

    }

    @AfterMethod(groups = {"Authorizer" , "Inputter", "IBGInputter", "IBGAuthorizer","InputterNewEnv","AuthorizerNewEnv"})
    public void userLogout(){
        this.driver.close();

        PageObject.switchToParentWindow(homePage);

        PageObject.switchFrame(0);

        PageObject.signOff();

        this.driver.close();
    }


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




