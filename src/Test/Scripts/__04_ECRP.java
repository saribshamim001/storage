package Test.Scripts;

import POM.PageObject;
import Test.General.BaseClass;
import org.testng.annotations.Test;
public class __04_ECRP {
    @Test
    public void individualCustomerECRP() throws InterruptedException {

        PageObject.menu_Dropdown("Customer Relation Officer Menu");
        PageObject.menu_Dropdown("Alfalah Customer Information");
        PageObject.menu_Dropdown("Branch Level Inputter");
        PageObject.childmenu_Dropdown("Alfalah Customer Information",2);
        PageObject.menu_Link("Individual/Sole/Proprietorship/Minor ");

        PageObject.parentFrame();
        PageObject.switchFrame(2);

        PageObject.textinput_Locator("transactionId","");

//       check ??
        PageObject.click_Locator("Edit a contract");
        PageObject.textinput_Locator("fieldName:CUS.CATEG:1","1003");

        PageObject.getTxn();

    }

    @Test
    public void corporateCustomerECRP() throws InterruptedException {

        PageObject.menu_Dropdown("Customer Relation Officer Menu");
        PageObject.menu_Dropdown("Alfalah Customer Information");
        PageObject.menu_Dropdown("Branch Level Inputter");
        PageObject.childmenu_Dropdown("Alfalah Customer Information",2);
        PageObject.menu_Link("Corporate Customers ");

        PageObject.parentFrame();
        PageObject.switchFrame(2);

        PageObject.textinput_Locator("transactionId","");
        PageObject.click_Locator("Edit a contract");
        // how to expand
        PageObject.textinput_Locator("fieldName:CUS.CATEG:1","1003");

        PageObject.getTxn();

    }
}
