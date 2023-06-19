package Test.Scripts.Conventional.CentralizedStandingInstruction;

import POM.PageObject;
import Test.General.BaseClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class OrderInputterMenu extends BaseClass {

    public static String txn;

    @Test(groups = {"CaoInputter2"} )
    public void customerCreation() throws IOException{

        PageObject.menu_Dropdown("Standing Order- Inputter Menu");
        PageObject.menu_Link("Maintain Minumum Balance ");
PageObject.switchToChildWindow();
        PageObject.textinput_Locator("transactionId","1007735360");
        PageObject.img_Button("Edit a contract");
        PageObject.click_Locator("fieldName:CURRENT.AMOUNT.BAL");
        PageObject.textinput_Locator("fieldName:CURRENT.AMOUNT.BAL","25000");
        PageObject.textinput_Locator("fieldName:CURRENT.FREQUENCY","e0Y e0M e1W e0D e0F");
        PageObject.textinput_Locator("fieldName:CPTY.ACCT.NO","test");
        PageObject.textinput_Locator("fieldName:PAYMENT.DETAILS:1","1007735958");
        PageObject.textinput_Locator("fieldName:COMMISSION.TYPE:1","STOCOMS");
//        PageObject.img_Button("Commit the deal");




    }
}
