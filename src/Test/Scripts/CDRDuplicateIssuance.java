package Test.Scripts;

import POM.PageObject;
import Test.General.BaseClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class CDRDuplicateIssuance extends BaseClass {

    @Test( groups = {"Inputter"})

    public void DemandDraftDuplication() throws InterruptedException, IOException {

        PageObject.menu_Dropdown("Remittance/Clearing Officer -Universal Teller");
        PageObject.menu_Dropdown("Remittance Menu");
        PageObject.menu_Dropdown("Alfalah Core/Retail Menu ");
        PageObject.childmenu_Dropdown("Customer Services",2);
        PageObject.menu_Dropdown("Call Deposit Receipt- Inputter Menu");
        PageObject.menu_Dropdown("Call Deposit Receipt Maintenance");
        PageObject.menu_Link("Call Deposit Receipt- Duplicate Issuance ");

        PageObject.textinput_Locator("value:1:1:1","1234567");


    }

}
