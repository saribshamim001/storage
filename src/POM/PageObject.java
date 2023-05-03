package POM;

import Test.General.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class PageObject extends BaseClass {

    public static WebDriver driver;
    public static Actions action;
    public static String parentWindow;

    public PageObject(WebDriver driver) {
        this.driver = driver;

    }

    //This method is to perform actions on Form Input Fields
    public static void textinput_Locator(String Id , String value) {

        driver.findElement(By.xpath("//tr/td/input[@id='"+Id+"']")).clear();
        driver.findElement(By.xpath("//tr/td/input[@id='"+Id+"']")).sendKeys(value);

    }

    //This method is to perform click on Form Input Fields
    public static void click_Locator (String Id) {

        driver.findElement(By.xpath("//tr/td/input[@id='"+Id+"']")).click();

    }

    //This method is to perform actions on Form Images
    public static void img_Button (String alt_Value) {
        driver.findElement(By.xpath("//tr/td/a/img[@alt='"+alt_Value+"']")).click();
    }

    public static void find_Button (String alt_Value) {
        driver.findElement(By.xpath("//tr/td/a[@alt='"+alt_Value+"']")).click();
    }

    //This method is to perform action on Static Select Dropdowns
    public static void select_Locator (String Id , String value) {
        WebElement Dropdown = driver.findElement(By.xpath("//tr/td/select[@id='"+Id+"']"));
        Select static_Dropdown = new Select(Dropdown);
        static_Dropdown.selectByValue(value);
    }

    //This method is to perform SignIn action
    public static void signIn (String userName , String passWord) {
        driver.findElement(By.xpath("//input[@name='signOnName']")).sendKeys(userName);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(passWord);
        driver.findElement(By.xpath("//input[@type='submit']")).click();
    }

    //Switch Frame
    public static void switchFrame(int index){
        driver.switchTo().frame(index);
    }

    public static void parentFrame(){
        driver.switchTo().parentFrame();
    }

    //This method is to perform actions on Form Textarea Fields
    public static void textarea_Locator (String Id , String value) {
        driver.findElement(By.xpath("//tr/td/textarea[@id='"+Id+"']")).clear();
        driver.findElement(By.xpath("//tr/td/textarea[@id='"+Id+"']")).sendKeys(value);
    }

    //This method is to perform actions on Form Radio Buttons
    public static void radiobutton_Locator(String Id , int index) {
        //tr/td/input/following-sibling::span[text()='Small']
        driver.findElement(By.xpath("(//tr/td/input[@id='"+Id+"'])["+index+"]")).click();
    }

    //This method is to perform actions on In-Form Tabs
    public static void form_Tab(String text_Value) {
        driver.findElement(By.xpath("//tr/td/a/span[text()='"+text_Value+"']")).click();
    }

//    //This method is to perform action of Accept Override
//    public static void acceptOverride() {
//        driver.findElement(By.xpath("//tr/td/a[text()='Accept Overrides']")).click();
//    }

    //This method is to Expand/Collapse Menu Items
    public static void menu_Dropdown(String alt_Value) {
        driver.findElement(By.xpath("//ul/li/span/img[@alt='"+alt_Value+"']")).click();
    }

    public static void childmenu_Dropdown(String alt_Value, Integer index) {
        driver.findElement(By.xpath("(//ul/li/span/img[@alt='"+alt_Value+"'])["+index+"]")).click();
    }

    //This method is to perform a click on Menu Links
    public static void menu_Link(String text_Value) {
        driver.findElement(By.xpath("//ul/li/a[text()='"+text_Value+"']")).click();
    }

    public static void form_Link(String text_Value) {
        driver.findElement(By.xpath("//table/tbody/tr/td/a[text()='"+text_Value+"']")).click();
    }

    public static void authorizeDeal () {
        driver.findElement(By.xpath("//tr/td/a/img[@alt='Authorises a deal']")).click();
        WebElement override = driver.findElement(By.xpath("//tr/td/a[text()='Accept Overrides']"));
        if (override.isDisplayed()){
            override.click();
        }
    }

    //Generate Random Numbers

    public static int idNumber() {
        Random rand = new Random();
        int min = 10000;
        int max = 99999;

        int rand_value = rand.nextInt((max - min) + 1) + min;
        return rand_value;
    }

    public static String switchToChildWindow() {
        String homePage = driver.getWindowHandle();
        for (String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
        return homePage;
    }

    public static void switchToParentWindow(String window){
        driver.switchTo().window(window);
    }

    public static void maximizeWindow(){
        driver.manage().window().maximize();
    }

    public static void txnValidate(String testCaseName) throws IOException {
       WebElement Txn = driver.findElement(By.xpath("//table/tbody/tr/td[contains(text(),'Txn Complete:')]"));
       Assert.assertTrue(Txn.isDisplayed(),"Transaction Un-Successful");
       File file = new File(System.getProperty("user.dir") + "\\Data\\" +testCaseName+ ".csv");
       String pattern = "\\d+";
       Pattern r = Pattern.compile(pattern);
       Matcher m = r.matcher(Txn.getText());

       if (m.find()) {
           String TxnNum = m.group();
           System.out.println("Extracted TXN Number: "+TxnNum);

           try {
               BufferedWriter outFile;
               outFile = new BufferedWriter(new FileWriter(file, true));
               outFile.append(TxnNum);
               outFile.newLine();
               outFile.close();
           } catch (IOException e) {
               System.out.println("Excel Not Working");
           }

       } else {
           System.out.println("TXN number not found");
       }
    }

    public static void commitDeal (String testCaseName) throws IOException {
        driver.findElement(By.xpath("//tr/td/a/img[@alt='Validate a deal']")).click();
        driver.findElement(By.xpath("//tr/td/a/img[@alt='Commit the deal']")).click();
        if (driver.getPageSource().contains("Txn Complete:")){
            txnValidate(testCaseName);
        }else{
            try {
                WebElement acpOverride = driver.findElement(By.xpath("//tr/td/a[text()='Accept Overrides']"));
                acpOverride.click();
                txnValidate(testCaseName);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }

    }

    public static String getTxn () {
        WebElement Txn = driver.findElement(By.xpath("//table/tbody/tr/td[contains(text(),'Txn Complete:')]"));
        String pattern = "\\d+";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(Txn.getText());
        String TxnNum ="";

        if (m.find()) {
            TxnNum = m.group();


        } else {
            System.out.println("TXN number not found");
        }
        return TxnNum;
    }



    //This method is for user SignOff
    public static void signOff() {
        driver.findElement(By.xpath("//tr/td/a[@alt='Sign off']")).click();
    }

}