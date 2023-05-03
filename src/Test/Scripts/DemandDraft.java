package Test.Scripts;

import POM.PageObject;
import Test.General.BaseClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class DemandDraft extends BaseClass {

    @Test( groups = {"Inputter"})
    public void demandDraftInput() throws InterruptedException, IOException {

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

        PageObject.textinput_Locator("fieldName:CREDIT.AMOUNT","1000");
        PageObject.textinput_Locator("fieldName:DEBIT.ACCT.NO","1007737725");
        PageObject.click_Locator("fieldName:CHEQUE.NUMBER");

        String HomePage2 = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();
        driver.close();

        PageObject.switchToParentWindow(HomePage2);
        PageObject.switchFrame(2);

        PageObject.textinput_Locator("fieldName:BEN.CUSTOMER:1","Ahmed Ali");
        PageObject.radiobutton_Locator("radio:tab1:COMMISSION.CODE" , 3 );
        PageObject.textinput_Locator("fieldName:COMMISSION.TYPE:1","ADTXF0029");
        PageObject.textinput_Locator("fieldName:COMMISSION.AMT:1","PKR 0.00");
        PageObject.form_Tab("Due Delligence");

        PageObject.textinput_Locator("fieldName:DD.ADDRESS:1","St.1 , ABC Street");
        PageObject.textinput_Locator("fieldName:ID.TYPE","ID-N");
        PageObject.textinput_Locator("fieldName:ID.NUMBER","4220198956233");
        PageObject.textinput_Locator("fieldName:CONTACT.NO:1","03336092323");
        PageObject.select_Locator("fieldName:INS.ISS.PURPOSE","Embassy/Visa Fee");


        PageObject.commitDeal("demandDraftInput");


    }
}
