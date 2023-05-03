package Test.Scripts;

import POM.PageObject;
import Test.General.BaseClass;
import org.testng.annotations.Test;

public class DemandDraft extends BaseClass {
    @Test( groups = {"Inputter"})
    public void demandDraftInput() {

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

        String HomePage2 = PageObject.switchToChildWindow();

        this.driver.close();

//        homePage = PageObject.switchToChildWindow();

//        this.driver.close();

        //PageObject.textinput_Locator("fieldName:CHEQUE.NUMBER","");
        PageObject.textinput_Locator("fieldName:BEN.CUSTOMER:1","Ahmed Ali");
        PageObject.radiobutton_Locator("radio:tab1:COMMISSION.CODE" , 3 );
        PageObject.textinput_Locator("fieldName:COMMISSION.TYPE:1","ADTXF0029");
        PageObject.textinput_Locator("fieldName:COMMISSION.AMT:1","PKR 0.00");

        PageObject.commitDeal();


    }
}
