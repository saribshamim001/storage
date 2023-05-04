package Test.Scripts;

import POM.PageObject;
import Test.General.BaseClass;
import org.openqa.selenium.devtools.v85.page.Page;
import org.testng.annotations.Test;

import java.io.IOException;

public class Assign_Locker extends BaseClass {

    String txn;

    @Test(groups = {"Inputter"})

    public void Assign_Locker() throws IOException, InterruptedException {

        PageObject.menu_Dropdown("Remittance/Clearing Officer -Universal Teller");
        PageObject.menu_Dropdown("Remittance Menu");
        PageObject.menu_Dropdown("Alfalah Core/Retail Menu ");
        PageObject.menu_Dropdown("Locker Inputter Menu");
        PageObject.menu_Dropdown("Assign Locker");


        PageObject.menu_Link("Assign Locker ");

        String menu = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();

        PageObject.form_Link("Joint");

        PageObject.textinput_Locator("fieldName:KEY","3");
        PageObject.textinput_Locator("fieldName:CUSTOMER","12105488");
        PageObject.click_Locator("fieldName:CUST.ACCT");

        Thread.sleep(2000);

        PageObject.textinput_Locator("fieldName:CUST.ACCT","1004057212");
        PageObject.textinput_Locator("fieldName:JOINT.CNO:1","11745297");
        PageObject.select_Locator("fieldName:OPEARTING.INST","Jointly");
        PageObject.textinput_Locator("fieldName:OPEARTING.NAME:1","Test J");
        PageObject.radiobutton_Locator("radio:mainTab:CHARGES.WAIVE",2);
        PageObject.radiobutton_Locator("radio:mainTab:KEY.DEPOSIT",1);
        PageObject.radiobutton_Locator("radio:tab1:MANDATEE",2);


        PageObject.commitDeal("Assign Locker");

        String menu1 = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();

        PageObject.img_Button("Commit the deal");

        txn = PageObject.getTxn();
        System.out.println(txn);



        
    }
}
