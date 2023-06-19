package Test.Scripts.Conventional.PayrollFundTrasnfer;

import POM.PageObject;
import Test.General.BaseClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Map;

public class PayrollFundTransfer extends BaseClass {

    @Test(groups = {"CaoInputter2"})
    public void PayrollFundTransfer() throws IOException{

        PageObject.menu_Dropdown("Funds Transfer Menu");
        PageObject.menu_Link("Funds Transfer ");
        PageObject.switchToChildWindow();
        driver.manage().window().maximize();
        PageObject.img_Button("New Deal");
        PageObject.textinput_Locator("fieldName:DEBIT.ACCT.NO","1007525495");
        PageObject.click_Locator("fieldName:DEBIT.AMOUNT");
        PageObject.textinput_Locator("fieldName:DEBIT.AMOUNT","500");
        PageObject.textinput_Locator("fieldName:CHEQUE.NUMBER","10102233");
        PageObject.textinput_Locator("fieldName:CREDIT.ACCT.NO","1007587609");
        PageObject.click_Locator("fieldName:CREDIT.VALUE.DATE");
        PageObject.textinput_Locator("fieldName:TREASURY.RATE","12");
        PageObject.radiobutton_Locator("radio:tab1:AML.TYP.CUST",2);
        PageObject.textarea_Locator("fieldName:NAME.COND.TXN","abd");
        PageObject.textinput_Locator("fieldName:CNIC.NO","12345");
        PageObject.img_Button("Validate a deal");
        //asdasd




    }




}
