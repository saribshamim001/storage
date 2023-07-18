package Test.Scripts.IBG.TDR;

import POM.PageObject;
import Test.General.BaseClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class TDRMaturity_IBG extends BaseClass {

    @Test(groups = {"InputterTDR_IBG"})
    public void TDRIssuanceMaturityLCY_IBG () throws IOException, InterruptedException {

        PageObject.menu_Dropdown("Centralized TDR Menu - IBG");
        PageObject.childmenu_Dropdown("Term Deposit at Maturity Menu", 1);
        PageObject.childmenu_Link("Term Deposit Issuance LCY ", 1);

        String menu = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();

        PageObject.textinput_Locator("fieldName:CUSTOMER.ID", "11871120");
        PageObject.click_Locator("fieldName:CATEGORY");
        //PageObject.textinput_Locator("fieldName:JOINT.CUSTOMER", "11745297");
        PageObject.textinput_Locator("fieldName:CATEGORY", "21022");
        PageObject.textinput_Locator("fieldName:REST.PERIOD.LD", "T1YA");
        PageObject.click_Locator("fieldName:AMOUNT:1");
        PageObject.textinput_Locator("fieldName:AMOUNT:1", "100000");
        PageObject.commitDeal("TDRIssuanceMaturityLCY_IBG");

    }

    @Test(groups = {"InputterTDR_IBG"})
    public void TDRIssuanceMaturityFCY_IBG () throws IOException, InterruptedException {

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
        PageObject.commitDeal("TDRIssuanceMaturityFCY_IBG");

    }

    @Test(groups = {"InputterTDR_IBG"})
    public void TDRBackDatedMaturityLCY_IBG () throws IOException, InterruptedException {

        PageObject.menu_Dropdown("Centralized TDR Menu - IBG");
        PageObject.childmenu_Dropdown("Term Deposit at Maturity Menu", 1);
        PageObject.childmenu_Link("Back Dated Term Deposit LCY  ", 1);

        String menu = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();

        PageObject.textinput_Locator("fieldName:CUSTOMER.ID", "12105488");
        PageObject.click_Locator("fieldName:CATEGORY");
        PageObject.textinput_Locator("fieldName:JOINT.CUSTOMER", "11745297");
        PageObject.textinput_Locator("fieldName:VALUE.DATE", "20230103");
        PageObject.click_Locator("fieldName:CATEGORY");
        PageObject.textinput_Locator("fieldName:CATEGORY", "21022");
        PageObject.textinput_Locator("fieldName:REST.PERIOD.LD", "DF1YMTA");
        PageObject.click_Locator("fieldName:AMOUNT:1");
        PageObject.textinput_Locator("fieldName:AMOUNT:1", "100");
        PageObject.commitDeal("TDRBackDatedMaturityFCY_IBG");


    }

    @Test(groups = {"InputterTDR_IBG"})
    public void TDRBackDatedMaturityFCY_IBG () throws IOException, InterruptedException {

        PageObject.menu_Dropdown("Centralized TDR Menu - IBG");
        PageObject.childmenu_Dropdown("Term Deposit at Maturity Menu", 1);
        PageObject.childmenu_Link("Back Dated Term Deposit LCY  ", 1);

        String menu = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();

        PageObject.textinput_Locator("fieldName:CUSTOMER.ID", "12105488");
        PageObject.click_Locator("fieldName:CATEGORY");
        PageObject.textinput_Locator("fieldName:JOINT.CUSTOMER", "11745297");
        PageObject.textinput_Locator("fieldName:VALUE.DATE", "20230103");
        PageObject.click_Locator("fieldName:CATEGORY");
        PageObject.textinput_Locator("fieldName:CATEGORY", "21022");
        PageObject.textinput_Locator("fieldName:REST.PERIOD.LD", "DF1YMTA");
        PageObject.click_Locator("fieldName:AMOUNT:1");
        PageObject.textinput_Locator("fieldName:AMOUNT:1", "100");
        PageObject.commitDeal("TDRBackDatedMaturityFCY_IBG");


    }

    @Test(groups = {"InputterTDR_IBG"})
    public void TDRAmendmentPreMaturity () throws IOException, InterruptedException {

        PageObject.menu_Dropdown("Centralized TDR Menu - IBG");
        PageObject.childmenu_Dropdown("Term Deposit at Maturity Menu", 1);
        PageObject.childmenu_Link("Term Deposit Amendment/Pre-Maturity ", 1);

        String menu = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();
        PageObject.switchFrame(0);

        PageObject.img_Button("Selection Screen");
        PageObject.textinput_Locator("value:1:1:1","LD1430416803");
        PageObject.find_Button();
        PageObject.form_Link("Amend");
        PageObject.parentFrame();
        PageObject.switchFrame(1);
        Thread.sleep(4000);
        PageObject.commitDeal("TDRAmendmentPreMaturity");
        PageObject.switchToChildWindow();
        Thread.sleep(4000);
        PageObject.switchToParentWindow(menu);
        PageObject.switchToChildWindow();


    }
}

