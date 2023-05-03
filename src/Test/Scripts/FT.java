package Test.Scripts;

import POM.PageObject;
import Test.General.BaseClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class FT extends BaseClass {
    Customer_Create asd = new Customer_Create();

    @Test( groups = {"Inputter"})
    public void fundTransferOnline() throws IOException {
        PageObject.menu_Dropdown("Head Teller Menu-Universal Teller-Conventiona");
        PageObject.menu_Link("Account to Account Transfer- Online ");

        System.out.println(asd.txn);
        PageObject.parentFrame();
        PageObject.switchFrame(2);

        PageObject.img_Button("New Deal");

        PageObject.textinput_Locator("fieldName:CREDIT.ACCT.NO","1007606991");
        PageObject.click_Locator("fieldName:CREDIT.AMOUNT");

//        String newPageCSO = driver.getWindowHandle();

        String newPage = PageObject.switchToChildWindow();
        driver.close();

        PageObject.switchToParentWindow(newPage);
        PageObject.switchFrame(2);

        PageObject.textinput_Locator("fieldName:CREDIT.AMOUNT","10");
        PageObject.textinput_Locator("fieldName:DEBIT.ACCT.NO","1007609217");
        PageObject.click_Locator("fieldName:CREDIT.AMOUNT");

        PageObject.switchToChildWindow();
        driver.close();

        PageObject.switchToParentWindow(newPage);
        PageObject.switchFrame(2);

        PageObject.radiobutton_Locator("radio:mainTab:AML.TYP.CUST",1);

        PageObject.commitDeal("Fund Transfer");
    }


}
