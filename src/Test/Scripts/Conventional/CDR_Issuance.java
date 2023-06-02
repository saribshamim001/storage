package Test.Scripts.Conventional;

import POM.PageObject;
import Test.General.BaseClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class CDR_Issuance extends BaseClass {

    @Test( groups = {"Inputter"})

    public void CDRIssuanceinput() throws InterruptedException, IOException {

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

        PageObject.textinput_Locator("fieldName:DEBIT.ACCT.NO","1000264788");
        PageObject.textinput_Locator("fieldName:BEN.CUSTOMER:1","SARA");
        PageObject.textinput_Locator("fieldName:CREDIT.AMOUNT","100");
        PageObject.radiobutton_Locator("radio:mainTab:COMMISSION.CODE" , 4);
        //PageObject.textinput_Locator("fieldName:COMMISSION.TYPE:1","WAIVE");

        PageObject.form_Tab("Due Delligence");

        PageObject.textinput_Locator("fieldName:DD.ADDRESS:1","D1-SAT");
        PageObject.textinput_Locator("fieldName:ID.TYPE","ID-N");
        PageObject.textinput_Locator("fieldName:ID.NUMBER","4220190909123");
        PageObject.textinput_Locator("fieldName:CONTACT.NO:1","03338980967");
        PageObject.select_Locator("fieldName:INS.ISS.PURPOSE", "Business Investment");

        PageObject.commitDeal("CDRBulkIssueInput");


    }

    @Test(groups = {"Authorizer"})

    public void CDRIssuance_Auth() throws IOException, InterruptedException {

        PageObject.menu_Dropdown("Manager Operation Menu");
        PageObject.menu_Dropdown("Core Retail Menu");
        PageObject.menu_Dropdown("Call Deposit Receipt- Authorizer Menu");
        PageObject.menu_Dropdown("Call Deposit Receipt Instrument Authorization");

        PageObject.menu_Link("Authorization of Single CDR Issuance ");

        //String menu1 = PageObject.switchToChildWindow();

        PageObject.form_Link("Authorize Transaction");

        String menu2 = PageObject.switchToChildWindow();

        PageObject.img_Button("Authorises a deal");

    }



    }

