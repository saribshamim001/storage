package Test.Scripts.Conventional;

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
        //Remenbering Current page info
        String HomePage2 = driver.getWindowHandle();
        PageObject.menu_Link("Call Deposit Receipt- Duplicate Issuance ");

        //Switch to newly opened window
        PageObject.switchToChildWindow();
        PageObject.textinput_Locator("value:1:1:1","CDR.LDA0610374");

        PageObject.find_Button();

        PageObject.maximizeWindow();

        PageObject.form_Link("Duplicate Issue");

        PageObject.commitDeal("DemandDraftDuplication");

    }


    @Test(groups = {"Authorizer"})

    public void DemandDraftDup_Auth() throws IOException, InterruptedException {

        PageObject.menu_Dropdown("Manager Operation Menu");
        PageObject.menu_Dropdown("Core Retail Menu");

        PageObject.menu_Dropdown("Call Deposit Receipt- Authorizer Menu");

        PageObject.menu_Dropdown("Call Deposit Receipt Maintenance Authorize");

        PageObject.menu_Link("Authorization of Duplicate CDR Issuance  ");

        String menu1 = PageObject.switchToChildWindow();

        PageObject.find_Button();

        PageObject.form_Link("Authorize Transaction");

        String menu2 = PageObject.switchToChildWindow();
        PageObject.img_Button("Authorises a deal");


    }
}
