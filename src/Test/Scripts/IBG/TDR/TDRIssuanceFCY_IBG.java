package Test.Scripts.IBG.TDR;

import POM.PageObject;
import Test.General.BaseClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class TDRIssuanceFCY_IBG extends BaseClass {

    @Test(groups = {"InputterTDR_IBG"})
    public void TDRIssuanceFCY_IBG () throws IOException, InterruptedException {

        PageObject.menu_Dropdown("Centralized TDR Menu - IBG");
        PageObject.childmenu_Dropdown("Term Deposit at Maturity Menu", 1);
        PageObject.childmenu_Link("Term Deposit Issuance FCY ", 1);

        String menu = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();

        PageObject.textinput_Locator("fieldName:CUSTOMER.ID", "12105488");
        PageObject.click_Locator("fieldName:CATEGORY");
        PageObject.textinput_Locator("fieldName:JOINT.CUSTOMER", "11745297");
        PageObject.textinput_Locator("fieldName:CATEGORY", "21022");
        PageObject.textinput_Locator("fieldName:REST.PERIOD.LD", "DFOMTDA");
        PageObject.click_Locator("fieldName:AMOUNT:1");
        PageObject.textinput_Locator("fieldName:AMOUNT:1", "100");
        PageObject.commitDeal("TDRIssuanceFCY_IBG");


    }
}