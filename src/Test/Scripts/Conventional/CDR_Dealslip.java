package Test.Scripts.Conventional;

import POM.PageObject;
import Test.General.BaseClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class CDR_Dealslip extends BaseClass {

    @Test( groups = {"Inputter"})

    public void DemandDraftCancellation() throws InterruptedException, IOException {

        PageObject.menu_Dropdown("Remittance/Clearing Officer -Universal Teller");
        PageObject.menu_Dropdown("Remittance Menu");
        PageObject.menu_Dropdown("Alfalah Core/Retail Menu ");
        PageObject.childmenu_Dropdown("Customer Services",2);
        PageObject.menu_Dropdown("Call Deposit Receipt- Inputter Menu");

        PageObject.menu_Dropdown("Call Deposit Receipt Issuance ");

        PageObject.menu_Link("Call Deposit Receipt- Single Issuance ");

        PageObject.parentFrame();
        PageObject.switchFrame(2);

        PageObject.img_Button("New Deal");

        PageObject.textinput_Locator("fieldName:DEBIT.ACCT.NO","");
        PageObject.textinput_Locator("fieldName:BEN.CUSTOMER:1","");








    }
}
