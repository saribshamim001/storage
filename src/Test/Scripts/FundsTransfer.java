package Test.Scripts;

import POM.PageObject;
import Test.General.BaseClass;
import org.openqa.selenium.devtools.v85.page.Page;
import org.testng.annotations.Test;

import java.io.IOException;

public class FundsTransfer extends BaseClass {

    @Test(groups = {"Inputter"})
    public void fTGeneral() throws IOException {

        String HomePage2 = driver.getWindowHandle();
        PageObject.menu_Dropdown("Head Teller Menu-Universal Teller-Conventiona");
        PageObject.menu_Link("Account to Account Transfer ");
        PageObject.parentFrame();
        PageObject.switchFrame(2);
        PageObject.img_Button("New Deal");


        PageObject.textinput_Locator("fieldName:DEBIT.ACCT.NO","PKR140030030");
        PageObject.click_Locator("fieldName:DEBIT.AMOUNT");
        PageObject.switchToChildWindow();
        driver.close();
        PageObject.switchToParentWindow(HomePage2);
        PageObject.parentFrame();
        PageObject.switchFrame(2);
        PageObject.textinput_Locator("fieldName:DEBIT.AMOUNT","1234");


        PageObject.textinput_Locator("fieldName:CREDIT.ACCT.NO","PKR149010005");
        PageObject.click_Locator("fieldName:DEBIT.AMOUNT");
        PageObject.switchToChildWindow();
        driver.close();
        PageObject.switchToParentWindow(HomePage2);
        PageObject.parentFrame();
        PageObject.switchFrame(2);

        PageObject.radiobutton_Locator("radio:mainTab:AML.TYP.CUST",2);
        PageObject.radiobutton_Locator("radio:mainTab:COMMISSION.CODE",1);

        PageObject.textarea_Locator("fieldName:NAME.COND.TXN","Customer");
        PageObject.textinput_Locator("fieldName:ID.TYPE","ID-N");
        PageObject.textinput_Locator("fieldName:ID.NUMBER","4220797762483");
        PageObject.textinput_Locator("fieldName:ID.VAL.DT","21221231");
        PageObject.commitDeal("FundsTransfer");
    }

    @Test(groups = {"Inputter"})
    public void fTOnline() throws IOException {

        String HomePage2 = driver.getWindowHandle();
        PageObject.menu_Dropdown("Head Teller Menu-Universal Teller-Conventiona");
        PageObject.menu_Link("Account to Account Transfer- Online ");
        PageObject.parentFrame();
        PageObject.switchFrame(2);
        PageObject.img_Button("New Deal");


        PageObject.textinput_Locator("fieldName:DEBIT.ACCT.NO","");
        PageObject.click_Locator("fieldName:DEBIT.AMOUNT");
        PageObject.switchToChildWindow();
        driver.close();
        PageObject.switchToParentWindow(HomePage2);
        PageObject.parentFrame();
        PageObject.switchFrame(2);
        PageObject.textinput_Locator("fieldName:DEBIT.AMOUNT","");


        PageObject.textinput_Locator("fieldName:CREDIT.ACCT.NO","");
        PageObject.click_Locator("fieldName:DEBIT.AMOUNT");
        PageObject.switchToChildWindow();
        driver.close();
        PageObject.switchToParentWindow(HomePage2);
        PageObject.parentFrame();
        PageObject.switchFrame(2);

        PageObject.radiobutton_Locator("radio:mainTab:AML.TYP.CUST",2);
        PageObject.radiobutton_Locator("radio:mainTab:COMMISSION.CODE",1);

        PageObject.textarea_Locator("fieldName:NAME.COND.TXN","Customer");
        PageObject.textinput_Locator("fieldName:ID.TYPE","ID-N");
        PageObject.textinput_Locator("fieldName:ID.NUMBER","4220797762483");
        PageObject.textinput_Locator("fieldName:ID.VAL.DT","21221231");
        PageObject.commitDeal("FundsTransfer");
    }
}
