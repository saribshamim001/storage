/*
package Test.Scripts;

import POM.PageObject;
import org.openqa.selenium.By;

public class FT_ACtoAC extends PageObject {

    public static void main(String[] args) throws InterruptedException {

        //Called from Main.Java File
        driverConfig();



        PageObject.signIn("retail01","QWer1234");

        driver.switchTo().frame(1);

        PageObject.menu_Dropdown("CSO - Conventional");
        PageObject.menu_Link("CSO - Conventional ");

        String winHandleBefore = driver.getWindowHandle();
        for (String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }



        driver.manage().window().maximize();
        driver.switchTo().frame(1);


        PageObject.menu_Dropdown("Head Teller Menu-Universal Teller-Conventiona");
        PageObject.menu_Link("Account to Account Transfer- Online ");

        driver.switchTo().parentFrame();
        driver.switchTo().frame(2);
        driver.findElement(By.xpath("//td/a/img[@alt='New Deal']")).click();
        PageObject.textinput_Locator("fieldName:CREDIT.ACCT.NO","1007606991");
        driver.findElement(By.xpath("//input[@id='fieldName:CREDIT.AMOUNT']")).click();

        String newPageCSO = driver.getWindowHandle();
        for (String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }

        Thread.sleep(2000);
        driver.close();
        Thread.sleep(4000);
        driver.switchTo().window(newPageCSO);
        driver.switchTo().frame(2);

        PageObject.textinput_Locator("fieldName:CREDIT.AMOUNT","10");
        PageObject.textinput_Locator("fieldName:DEBIT.ACCT.NO","1007609217");
        driver.findElement(By.xpath("//input[@id='fieldName:CREDIT.AMOUNT']")).click();

        for (String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
        driver.close();

        driver.switchTo().window(newPageCSO);
        Thread.sleep(2000);
        driver.switchTo().frame(2);

        PageObject.radiobutton_Locator("radioCheckStyle_FUNDSTRANSFER_PKMBACTR2","Account Holder");
        PageObject.img_Button("Validate a deal");
        PageObject.img_Button("Commit the deal");
        PageObject.acceptOverride();
        driver.close();

        driver.switchTo().window(winHandleBefore);

        driver.switchTo().frame(0);

        PageObject.signOff();


//        driver.switchTo().window(winHandleBefore);




    }
}
*/