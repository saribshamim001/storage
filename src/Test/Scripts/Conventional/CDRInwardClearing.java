package Test.Scripts.Conventional;

import POM.PageObject;
import Test.General.BaseClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class CDRInwardClearing extends BaseClass {

    @Test( groups = {"Inputter"})

    public void CDRInwardClearingNormal() throws InterruptedException, IOException {

        PageObject.menu_Dropdown("Remittance/Clearing Officer -Universal Teller");
        PageObject.menu_Dropdown("Remittance Menu");
        PageObject.menu_Dropdown("Alfalah Core/Retail Menu ");
        PageObject.childmenu_Dropdown("Customer Services",2);
        PageObject.menu_Dropdown("Call Deposit Receipt- Inputter Menu");

        PageObject.menu_Dropdown("Call Deposit Receipt Inward Clearing");

        PageObject.menu_Link("Inward Clearing - Instrument Normal ");

        PageObject.parentFrame();
        PageObject.switchFrame(2);

        PageObject.img_Button("New Deal");

        //PageObject.textinput_Locator("fieldName:CREDIT.AMOUNT","1000");
        PageObject.textinput_Locator("fieldName:CL.NO.MV","1");
        PageObject.click_Locator("fieldName:CL.CHEQUE.NO:1");
        PageObject.textinput_Locator("fieldName:CL.CHEQUE.NO:1","123456789");
        PageObject.click_Locator("fieldName:BANK.SORT.CODE:1");

        String HomePage2 = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();
        driver.close();

//        String HomePage3 = PageObject.switchToChildWindow();
//        PageObject.maximizeWindow();
//        driver.close();

        PageObject.switchToParentWindow(HomePage2);
        PageObject.switchFrame(2);

        PageObject.textinput_Locator("fieldName:BANK.SORT.CODE:1","010");

        PageObject.commitDeal("CDRInwardClearingNormal");




    }
}
