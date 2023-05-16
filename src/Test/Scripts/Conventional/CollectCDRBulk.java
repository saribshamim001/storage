package Test.Scripts.Conventional;

import POM.PageObject;
import Test.General.BaseClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class CollectCDRBulk extends BaseClass {

    @Test( groups = {"Inputter"})

    public void CDRBulkIssuance() throws InterruptedException, IOException {

        PageObject.menu_Dropdown("Remittance/Clearing Officer -Universal Teller");
        PageObject.menu_Dropdown("Remittance Menu");
        PageObject.menu_Dropdown("Alfalah Core/Retail Menu ");
        PageObject.childmenu_Dropdown("Customer Services",2);
        PageObject.menu_Dropdown("Call Deposit Receipt- Inputter Menu");
        PageObject.menu_Dropdown("Call Deposit Receipt Issuance ");
        PageObject.menu_Link("Collect CDR Amount A/c Holder Bulk-Step-1 ");

        PageObject.parentFrame();
        PageObject.switchFrame(2);

        PageObject.img_Button("New Deal");

        PageObject.textinput_Locator("fieldName:CREDIT.AMOUNT","1000");
        PageObject.textinput_Locator("fieldName:DEBIT.ACCT.NO","1007737725");

        PageObject.click_Locator("fieldName:NO.OF.INST");

        String HomePage2 = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();
        driver.close();

        PageObject.switchToParentWindow(HomePage2);
        PageObject.switchFrame(2);

        PageObject.textinput_Locator("fieldName:NO.OF.INST","2");
        PageObject.radiobutton_Locator("radio:tab1:COMMISSION.CODE" , 3 );
        PageObject.textinput_Locator("fieldName:COMMISSION.TYPE:1","POCOMM");
        PageObject.textinput_Locator("fieldName:COMMISSION.AMT:1","PKR 0.00");

        PageObject.commitDeal("CDRBulkIssuance");



    }

}
