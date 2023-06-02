package Test.Scripts.Conventional;

import POM.PageObject;
import Test.General.BaseClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class IssueCDRBulk extends BaseClass {

    @Test(groups = {"Inputter"})

    public void CDRBulkIssueInput() throws InterruptedException, IOException {

        PageObject.menu_Dropdown("Remittance/Clearing Officer -Universal Teller");
        PageObject.menu_Dropdown("Remittance Menu");
        PageObject.menu_Dropdown("Alfalah Core/Retail Menu ");
        PageObject.childmenu_Dropdown("Customer Services", 2);
        PageObject.menu_Dropdown("Call Deposit Receipt- Inputter Menu");
        PageObject.menu_Dropdown("Call Deposit Receipt Issuance ");

        String HomePage2 = driver.getWindowHandle();
        PageObject.menu_Link("Issuance CDR- A/c Holder Bulk- Step-2 ");

        PageObject.switchToChildWindow();
        PageObject.textinput_Locator("value:1:1:1", "1003052809");

        PageObject.find_Button();

        Thread.sleep(2000);

        //PageObject.commitDeal("CDRBulkIssueInput");


    }

    @Test(groups = {"Authorizer"})


    public void CDRBulkIssue_Auth() throws IOException, InterruptedException {

        PageObject.menu_Dropdown("Manager Operation Menu");

        PageObject.menu_Dropdown("Core Retail Menu");

        PageObject.menu_Dropdown("Call Deposit Receipt- Authorizer Menu");

        PageObject.menu_Dropdown("Call Deposit Receipt Instrument Authorization");

        PageObject.menu_Link("Authorization of Bulk CDR Issuance- Step-1 ");

        String menu1 = PageObject.switchToChildWindow();

        PageObject.find_Button();

        PageObject.form_Link("Authorize Transaction");

        String menu2 = PageObject.switchToChildWindow();
        PageObject.img_Button("Authorises a deal");

    }

}
