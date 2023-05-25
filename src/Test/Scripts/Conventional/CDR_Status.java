package Test.Scripts.Conventional;

import POM.PageObject;
import Test.General.BaseClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class CDR_Status extends BaseClass {

    @Test(groups = {"Inputter"})

    public void CDRStatusStop() throws InterruptedException, IOException {

        //Data related issue, transaction couldn't perform properly

        PageObject.menu_Dropdown("Remittance/Clearing Officer -Universal Teller");
        PageObject.menu_Dropdown("Remittance Menu");
        PageObject.menu_Dropdown("Alfalah Core/Retail Menu ");
        PageObject.childmenu_Dropdown("Customer Services", 2);
        PageObject.menu_Dropdown("Call Deposit Receipt- Inputter Menu");
        PageObject.menu_Dropdown("Call Deposit Receipt Maintenance");


        String HomePage2 = driver.getWindowHandle();

        PageObject.menu_Link("Change Status of Instrument ");

        PageObject.switchToChildWindow();
        PageObject.textinput_Locator("value:1:1:1","CDR.LDA0610547");

        PageObject.find_Button();

        PageObject.maximizeWindow();

        PageObject.form_Link("Change Status");

        Thread.sleep(2000);

        PageObject.commitDeal("CDRStatusStop");


}
        //Authorizer not found
}
