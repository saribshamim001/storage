package Test.Scripts;

import POM.PageObject;
import Test.General.BaseClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class AmendmentLockerSingle extends BaseClass {
    String txn;

    @Test(groups = {"Inputter"})

    public void AmendmentLockerSingle() throws IOException, InterruptedException {

        PageObject.menu_Dropdown("Remittance/Clearing Officer -Universal Teller");
        PageObject.menu_Dropdown("Remittance Menu");
        PageObject.menu_Dropdown("Alfalah Core/Retail Menu ");
        PageObject.menu_Dropdown("Locker Inputter Menu");
        PageObject.menu_Dropdown("Locker Amendment");


        PageObject.menu_Link("Amendment of Locker Single ");

        String menu = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();

        PageObject.textinput_Locator("value:1:1:1","OR.0002.0031");
        PageObject.find_Button("Run Selection");


        PageObject.form_Link("Amendment Version");

        PageObject.textinput_Locator("fieldName:KEY","112");
        PageObject.select_Locator("fieldName:STATUS","ASSIGNED");
        PageObject.textinput_Locator("fieldName:CUST.ACCT","1003160019");
        PageObject.radiobutton_Locator("radio:tab1:CHARGES.WAIVE",1);
        PageObject.textinput_Locator("fieldName:BRK.REASON:1","Testing");

        PageObject.commitDeal("Amendment of Locker Single ");

    }
}
