package Test.Scripts;

import POM.PageObject;
import Test.General.BaseClass;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.IOException;

public class LockerSignature extends BaseClass {

    String sigTxn;
    @Test(groups = {"Inputter"})

    public void lockerSignautre() throws IOException, InterruptedException {

        PageObject.menu_Dropdown("Remittance/Clearing Officer -Universal Teller");
        PageObject.menu_Dropdown("Remittance Menu");
        PageObject.menu_Dropdown("Alfalah Core/Retail Menu ");
        PageObject.menu_Dropdown("Locker Inputter Menu");
        PageObject.menu_Dropdown("Locker Signature");


        PageObject.menu_Link("Upload Locker Signature ");

        String menu = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();

        PageObject.parentFrame();
        PageObject.switchFrame(2);


        PageObject.img_Button("New Deal");

        PageObject.textinput_Locator("fieldName:IMAGE.REFERENCE","OR.0004.0031");
        PageObject.textinput_Locator("fieldName:SHORT.DESCRIPTION","Test");
        PageObject.textinput_Locator("fieldName:DESCRIPTION:1","Tester");


        driver.findElement(By.xpath("//tr/td/a/img[@alt='Commit the deal']")).click();

        PageObject.parentFrame();
        PageObject.switchFrame(2);

        PageObject.textinput_Locator("fieldName:FILE.UPLOAD","ASD");

        PageObject.commitDeal("LockerSignature");


        sigTxn = PageObject.getTxn();
        System.out.println(sigTxn);

    }

}
