package Test.Scripts.IBG;

import POM.PageObject;
import Test.General.BaseClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Map;

public class CDR_Issuance_IBG extends BaseClass {

    @Test(groups = {"IBGInputter"})

    public void CDRIssueInputIBG() throws IOException, InterruptedException {

        PageObject.menu_Dropdown("Remittance Menu -Universal Teller- IBG");
        PageObject.menu_Dropdown("Call Deposit Receipt- Inputter Menu");
        PageObject.menu_Dropdown("Call Deposit Receipt Issuance ");
        PageObject.menu_Link("Call Deposit Receipt- Single Issuance ");

        PageObject.parentFrame();
        PageObject.switchFrame(2);

        PageObject.img_Button("New Deal");
        String HomePage2 = driver.getWindowHandle();
        PageObject.textinput_Locator("fieldName:DEBIT.ACCT.NO","1000264788");
        PageObject.click_Locator("fieldName:DEBIT.ACCT.NO");
        PageObject.textinput_Locator("fieldName:CREDIT.AMOUNT","100");
        PageObject.textinput_Locator("fieldName:BEN.CUSTOMER:1","SARA");

        PageObject.switchToChildWindow();
        driver.close();

        PageObject.switchToParentWindow(HomePage2);
        PageObject.switchFrame(2);

        PageObject.radiobutton_Locator("radio:mainTab:COMMISSION.CODE" , 4);

        PageObject.form_Tab("Due Delligence");

        PageObject.textinput_Locator("fieldName:DD.ADDRESS:1","D1-SAT");
        PageObject.textinput_Locator("fieldName:ID.TYPE","ID-N");
        PageObject.textinput_Locator("fieldName:ID.NUMBER","4220190909123");
        PageObject.textinput_Locator("fieldName:CONTACT.NO:1","03338980967");
        PageObject.select_Locator("fieldName:INS.ISS.PURPOSE", "Business Investment");

        PageObject.commitDeal("CDRIssueInputIBG");




}
}
