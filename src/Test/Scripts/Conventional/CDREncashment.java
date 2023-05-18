package Test.Scripts.Conventional;

import POM.PageObject;
import Test.General.BaseClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class CDREncashment extends BaseClass {

    @Test( groups = {"Inputter"})

    public void CDREncashmentTest() throws InterruptedException, IOException {

        PageObject.menu_Dropdown("Remittance/Clearing Officer -Universal Teller");
        PageObject.menu_Dropdown("Remittance Menu");
        PageObject.menu_Dropdown("Alfalah Core/Retail Menu ");
        PageObject.childmenu_Dropdown("Customer Services",2);
        PageObject.menu_Dropdown("Call Deposit Receipt- Inputter Menu");
        PageObject.menu_Dropdown("Call Deposit Receipt Maintenance");
        PageObject.menu_Link("Call Deposit Receipt Encashment (Within Bank) ");

        PageObject.parentFrame();
        PageObject.switchFrame(2);

        PageObject.img_Button("New Deal");

        //PageObject.textinput_Locator("fieldName:CREDIT.THEIR.REF","1000");

        PageObject.textinput_Locator("fieldName:CREDIT.ACCT.NO","1000140984");
        PageObject.click_Locator("fieldName:CREDIT.THEIR.REF");

        String HomePage2 = PageObject.switchToChildWindow();
        //PageObject.maximizeWindow();
        driver.close();

        PageObject.switchToParentWindow(HomePage2);
        PageObject.switchFrame(2);
        PageObject.textinput_Locator("fieldName:CREDIT.THEIR.REF","LDA0610297");

        PageObject.commitDeal("CDREncashment");
        //String txn = PageObject.getTxn();
        //System.out.println("Txn is: "+txn);
    }
}
