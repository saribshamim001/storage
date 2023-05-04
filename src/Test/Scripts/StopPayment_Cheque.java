package Test.Scripts;

import POM.PageObject;
import Test.General.BaseClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class StopPayment_Cheque extends BaseClass {

    @Test(groups = {"Inputter"},priority = 1)
    public void stopPayment_Cheque() throws IOException {
        PageObject.menu_Dropdown("Customer Relation Officer Menu");
        PageObject.menu_Dropdown("Cheque Book Management Inputter Menu");
        PageObject.menu_Link("Stop Payment of Cheque(s) ");
        PageObject.parentFrame();
        PageObject.switchFrame(2);
        PageObject.textinput_Locator("transactionId","1000009896");
        PageObject.img_Button("Edit a contract");

        PageObject.textinput_Locator("fieldName:PAYM.STOP.TYPE:1","3");
        PageObject.textinput_Locator("fieldName:FIRST.CHEQUE.NO:1","123456600");
        //PageObject.textinput_Locator("fieldName:LAST.CHEQUE.NO:1","123456791");
        PageObject.select_Locator("fieldName:WAIVE.CHARGE:1","YES");
        PageObject.commitDeal("StopPayment_Cheque");
        String txn = PageObject.getTxn();
        System.out.println("Txn is:  "+txn);
    }

    @Test(groups = {"Inputter"}, priority = 2)
    public void stopPayment_ChequeSeries() throws IOException {
        PageObject.menu_Dropdown("Customer Relation Officer Menu");
        PageObject.menu_Dropdown("Cheque Book Management Inputter Menu");
        PageObject.menu_Link("Stop Payment of Cheque(s) ");
        PageObject.parentFrame();
        PageObject.switchFrame(2);
        PageObject.textinput_Locator("transactionId","1000009896");
        PageObject.img_Button("Edit a contract");

        PageObject.textinput_Locator("fieldName:PAYM.STOP.TYPE:1","3");
        PageObject.textinput_Locator("fieldName:FIRST.CHEQUE.NO:1","123456601");
        PageObject.textinput_Locator("fieldName:LAST.CHEQUE.NO:1","123456610");
        PageObject.select_Locator("fieldName:WAIVE.CHARGE:1","YES");
        PageObject.commitDeal("stopPayment_ChequeSeries");
        String txn = PageObject.getTxn();
        System.out.println("Txn is:  "+txn);
    }

    //dependsOnMethods = {"stopPayment_Cheque","stopPayment_ChequeSeries"}
    //To make dependent on other methods
    @Test(groups = {"Inputter"}, priority = 3)
    public void stopPayment_RevokeCheque() throws IOException {
        PageObject.menu_Dropdown("Customer Relation Officer Menu");
        PageObject.menu_Dropdown("Cheque Book Management Inputter Menu");
        PageObject.menu_Link("Revoke Stop Payment of Cheque ");
        PageObject.parentFrame();
        PageObject.switchFrame(2);
        PageObject.textinput_Locator("transactionId","1000009896");
        PageObject.img_Button("Edit a contract");

        PageObject.textinput_Locator("fieldName:MOD.PS.CHQ.NO:1","123456601");
        PageObject.commitDeal("stopPayment_RevokeCheque");
        String txn = PageObject.getTxn();
        System.out.println("Txn is:  "+txn);
    }


}
