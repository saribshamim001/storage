package Test.Scripts.Conventional;

import POM.PageObject;
import Test.General.BaseClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class CDRRevalidation extends BaseClass {

    @Test( groups = {"Inputter"})

    public void CDRRevalidate() throws InterruptedException, IOException {

        PageObject.menu_Dropdown("Remittance/Clearing Officer -Universal Teller");
        PageObject.menu_Dropdown("Remittance Menu");
        PageObject.menu_Dropdown("Alfalah Core/Retail Menu ");
        PageObject.childmenu_Dropdown("Customer Services",2);
        PageObject.menu_Dropdown("Call Deposit Receipt- Inputter Menu");
        PageObject.menu_Dropdown("Call Deposit Receipt Maintenance");

        String HomePage2 = driver.getWindowHandle();
        PageObject.menu_Link("CDR Stale Instrument Re-validate ");

        PageObject.switchToChildWindow();
        PageObject.textinput_Locator("value:1:1:1","CDR.ADY1224014");

        PageObject.find_Button();

        PageObject.form_Link("Active Instrument");

        PageObject.commitDeal("CDRRevalidate");



    }
}
