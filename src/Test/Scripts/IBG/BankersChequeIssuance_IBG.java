package Test.Scripts.IBG;

import POM.PageObject;
import Test.General.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v85.page.Page;
import org.testng.annotations.Test;

import java.io.IOException;

public class BankersChequeIssuance_IBG extends BaseClass {

    @Test(groups = {"Inputter"})
    public void BankersCheqSingleIssuanceAccountHolder () throws IOException, InterruptedException {

        PageObject.menu_Dropdown("Remittance Menu -Universal Teller- IBG");
        PageObject.childmenu_Dropdown("Cheque- Inputter Menu", 1);
        PageObject.childmenu_Dropdown("Cheque Issuance", 1);
        PageObject.childmenu_Dropdown("Cheq Single Issuance Menu", 1);
        PageObject.childmenu_Link("Banker Cheque Single Issuance- Account Holder ", 1);

        PageObject.parentFrame();
        PageObject.switchFrame(2);
        String pgnameo = driver.getWindowHandle();

        PageObject.img_Button("New Deal");
        PageObject.textinput_Locator("fieldName:BEN.CUSTOMER:1", "Waqas Nadeem Khan");
        PageObject.form_Tab("Due Delligence");
        PageObject.textinput_Locator("fieldName:DD.ADDRESS:1", "123 Building");
        PageObject.textinput_Locator("fieldName:ID.TYPE", "ID-N");
        PageObject.textinput_Locator("fieldName:ID.NUMBER", "4222222222222");
        PageObject.textinput_Locator("fieldName:CONTACT.NO:1", "03333333333");
        PageObject.select_Locator("fieldName:INS.ISS.PURPOSE","Clearing/Forwarding Charges");
        PageObject.form_Tab("Issue Instrument (Local Currency)");
        PageObject.textinput_Locator("fieldName:CREDIT.AMOUNT", "6");
        PageObject.textinput_Locator("fieldName:DEBIT.ACCT.NO", "1");
        PageObject.commitDeal("BankersCheqSingleIssuanceAccountHolder");
        PageObject.switchToChildWindow();
    }

    @Test(groups = {"Authorizer"})
    public void BankersCheqSingleIssuanceAccountHolderAuth() throws InterruptedException, IOException {

        PageObject.childmenu_Dropdown("Cheque- Authorizer Menu", 1);
        PageObject.childmenu_Dropdown("Cheq Instrument SingleAuthorization ", 1);
        PageObject.childmenu_Link("Authorize Banker Chq Single-Act Holder", 1);

        String menu1 = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();
        PageObject.switchFrame(0);

        PageObject.img_Button("Selection Screen");
        PageObject.textinput_Locator("value:2:1:1","1");
        PageObject.find_Button();
        PageObject.form_Link("Authorise a Transaction");
        PageObject.parentFrame();
        PageObject.switchFrame(1);
        Thread.sleep(4000);
        PageObject.img_Button("Authorises a deal");
        PageObject.switchToChildWindow();
        driver.close();
        PageObject.switchToParentWindow(menu1);
        PageObject.switchToChildWindow();

    }

    @Test(groups = {"Inputter"})
    public void BankerChequeSingleIssuanceWalkinCust() throws IOException, InterruptedException {

        PageObject.menu_Dropdown("Remittance Menu -Universal Teller- IBG");
        PageObject.childmenu_Dropdown("Cheque- Inputter Menu", 1);
        PageObject.childmenu_Dropdown("Cheque Issuance", 1);
        PageObject.childmenu_Dropdown("Cheq Single Issuance Menu", 1);
        PageObject.childmenu_Link("Banker Cheque Single Issuance- Walk-in Cust ", 1);

        PageObject.parentFrame();
        PageObject.switchFrame(2);
        String pgnameo = driver.getWindowHandle();

        PageObject.img_Button("New Deal");
        PageObject.textinput_Locator("fieldName:CREDIT.AMOUNT", "14");
        PageObject.textinput_Locator("fieldName:INST.NUMBER", "TT23004508781055");
        PageObject.textinput_Locator("fieldName:BEN.CUSTOMER:1", "Waqas Nadeem Khan");
        PageObject.textinput_Locator("fieldName:ORDERING.CUST:1", "Waqass");
        PageObject.form_Tab("Due Delligence");
        PageObject.textinput_Locator("fieldName:APP.ADDRESS:1", "123 Building");
        PageObject.textinput_Locator("fieldName:APP.ID.TYPE", "ID-N");
        PageObject.textinput_Locator("fieldName:CNIC.NO", "4222222222222");
        PageObject.textinput_Locator("fieldName:APP.CONTACT.NO", "03333333333");
        PageObject.textinput_Locator("fieldName:APP.MOTHER.NAME", "Mother");
        PageObject.textinput_Locator("fieldName:DD.ADDRESS:1", "123 Building");
        PageObject.textinput_Locator("fieldName:ID.TYPE", "ID-N");
        PageObject.textinput_Locator("fieldName:ID.NUMBER", "4222222222221");
        PageObject.textinput_Locator("fieldName:CONTACT.NO:1", "03333333331");
        PageObject.select_Locator("fieldName:INS.ISS.PURPOSE","Clearing/Forwarding Charges");
        PageObject.form_Tab("Issue Instrument (Local Currency)");
        PageObject.commitDeal("BankerChequeSingleIssuanceWalkinCust");
        PageObject.switchToChildWindow();

    }

    @Test(groups = {"Authorizer"})
    public void BankerChequeSingleIssuanceWalkinCustAuth() throws InterruptedException, IOException {

        PageObject.childmenu_Dropdown("Cheque- Authorizer Menu", 1);
        PageObject.childmenu_Dropdown("Cheq Instrument SingleAuthorization ", 1);
        PageObject.childmenu_Link("Authorize Banker Chq Single-Walkin Customer ", 1);

        String menu1 = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();

        PageObject.textinput_Locator("value:1:1:1","111");
        PageObject.textinput_Locator("value:2:1:1","BC");
        PageObject.find_Button();
        PageObject.form_Link("Authorise a Transaction");
        PageObject.switchToChildWindow();
        PageObject.img_Button("Authorises a deal");
        PageObject.switchToParentWindow(menu1);
        PageObject.switchToChildWindow();

    }

    @Test(groups = {"Authorizer"})
    public void BankerChequeSingleIssuanceWalkinCustAuthDelete() throws InterruptedException, IOException {

        PageObject.childmenu_Dropdown("Cheque- Authorizer Menu", 1);
        PageObject.childmenu_Dropdown("Cheq Instrument SingleAuthorization ", 1);
        PageObject.childmenu_Link("Authorize Banker Chq Single-Walkin Customer ", 1);

        String menu1 = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();

        PageObject.textinput_Locator("value:3:1:1","100");
        PageObject.textinput_Locator("value:2:1:1","BC");
        PageObject.find_Button();
        PageObject.form_Link("Authorise a Transaction");
        PageObject.switchToChildWindow();
        PageObject.img_Button("Authorises a deal");
        PageObject.switchToParentWindow(menu1);
        PageObject.switchToChildWindow();

    }

    @Test(groups = {"Authorizer"})
    public void AuthorizeCollectionBankerChqCustMulti() throws InterruptedException, IOException {

        PageObject.childmenu_Dropdown("Cheque- Authorizer Menu", 1);
        PageObject.childmenu_Dropdown("Cheq Instrument Bulk Authorization ", 1);
        PageObject.childmenu_Link("Authorize Collection Banker Chq -Cust (Multi)", 1);

        String menu1 = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();
        PageObject.switchFrame(0);

        PageObject.img_Button("Selection Screen");
        PageObject.textinput_Locator("value:2:1:1","1006948260");
        PageObject.find_Button();
        PageObject.form_Link("Authorise a Transaction");
        PageObject.parentFrame();
        PageObject.switchFrame(1);
        PageObject.img_Button("Authorises a deal");
        PageObject.switchToChildWindow();
        PageObject.switchToParentWindow(menu1);
        PageObject.switchToChildWindow();

    }

    @Test(groups = {"Inputter"})
    public void BankerChequeSingleIssuanceVendorPayment() throws IOException, InterruptedException {

        PageObject.menu_Dropdown("Remittance Menu -Universal Teller- IBG");
        PageObject.childmenu_Dropdown("Cheque- Inputter Menu", 1);
        PageObject.childmenu_Dropdown("Cheque Issuance", 1);
        PageObject.childmenu_Dropdown("Cheq Single Issuance Menu", 1);
        PageObject.childmenu_Link("Banker Cheque Single Issuance- Vendor Payment ", 1);

        PageObject.parentFrame();
        PageObject.switchFrame(2);
        String pgnameo = driver.getWindowHandle();

        PageObject.img_Button("New Deal");
        PageObject.textinput_Locator("fieldName:BEN.CUSTOMER:1", "Waqas Nadeem Khan");
        PageObject.form_Tab("Due Delligence");
        PageObject.textinput_Locator("fieldName:APP.ADDRESS:1", "123 Building");
        PageObject.textinput_Locator("fieldName:CNIC.NO", "4222222222222");
        PageObject.textinput_Locator("fieldName:APP.CONTACT.NO", "03333333333");
        PageObject.textinput_Locator("fieldName:APP.MOTHER.NAME", "Mother");
        PageObject.textinput_Locator("fieldName:DD.ADDRESS:1", "123 Building");
        PageObject.textinput_Locator("fieldName:ID.TYPE", "ID-N");
        PageObject.textinput_Locator("fieldName:ID.NUMBER", "4222222222221");
        PageObject.textinput_Locator("fieldName:CONTACT.NO:1", "03333333331");
        PageObject.select_Locator("fieldName:INS.ISS.PURPOSE","Clearing/Forwarding Charges");
        PageObject.form_Tab("Issue Instrument (Local Currency)");
        PageObject.textinput_Locator("fieldName:CREDIT.AMOUNT", "6");
        PageObject.commitDeal("BankerChequeSingleIssuanceVendorPayment");
        PageObject.switchToChildWindow();

    }

    @Test(groups = {"Inputter"})
    public void FundTrfCreditVendorPaytActSingleBulk() throws IOException, InterruptedException {

        PageObject.menu_Dropdown("Remittance Menu -Universal Teller- IBG");
        PageObject.childmenu_Dropdown("Cheque- Inputter Menu", 1);
        PageObject.childmenu_Dropdown("Cheque Issuance", 1);
        PageObject.childmenu_Dropdown("Cheq Single Issuance Menu", 1);
        PageObject.childmenu_Link("Fund Trf Credit- Vendor Payt Act Single/ Bulk ", 1);

        PageObject.parentFrame();
        PageObject.switchFrame(2);
        String pgnameo = driver.getWindowHandle();

        PageObject.img_Button("New Deal");
        PageObject.textinput_Locator("fieldName:DEBIT.ACCT.NO", "PKR159795505");
        PageObject.textinput_Locator("fieldName:BEN.CUSTOMER:1", "Waqas");
        PageObject.switchToParentWindow(pgnameo);
        PageObject.switchFrame(2);
        PageObject.textinput_Locator("fieldName:DEBIT.AMOUNT", "14");
        PageObject.textinput_Locator("fieldName:ORDERING.BANK:1", "BAL");
        PageObject.textinput_Locator("fieldName:ORDERING.CUST:1", "Waqass");
        PageObject.textinput_Locator("fieldName:DEBIT.CURRENCY", "PKR");
        PageObject.commitDeal("FundTrfCreditVendorPaytActSingleBulk");
        PageObject.switchToChildWindow();

    }

    @Test(groups = {"Inputter"})
    public void CollectBankerChqAmtAcHolderBulkStep1 () throws IOException, InterruptedException {

        PageObject.menu_Dropdown("Remittance Menu -Universal Teller- IBG");
        PageObject.childmenu_Dropdown("Cheque- Inputter Menu", 1);
        PageObject.childmenu_Dropdown("Cheque Issuance", 1);
        PageObject.childmenu_Dropdown("Cheq  Bulk Issuance Menu A\\c Holder", 1);
        PageObject.childmenu_Link("Collect Banker Chq Amt A/c Holder Bulk-Step-1 ", 1);

        PageObject.parentFrame();
        PageObject.switchFrame(2);
        String pgnameo = driver.getWindowHandle();

        PageObject.img_Button("New Deal");
        PageObject.textinput_Locator("fieldName:DEBIT.ACCT.NO", "1007652804");
        PageObject.textinput_Locator("fieldName:BEN.CUSTOMER:1", "Waqas");
        PageObject.textinput_Locator("fieldName:NO.OF.INST", "2");
        PageObject.textinput_Locator("fieldName:CREDIT.AMOUNT", "14");
        PageObject.switchToParentWindow(pgnameo);
        PageObject.switchFrame(2);
        PageObject.img_Button("Commit the deal");
        PageObject.commitDeal("CollectBankerChqAmtAcHolderBulkStep1");
        PageObject.switchToChildWindow();

    }

    @Test(groups = {"Inputter"})
    public void IssuanceBankerChqAcHolderBulkStep2 () throws InterruptedException, IOException {

        PageObject.menu_Dropdown("Remittance Menu -Universal Teller- IBG");
        PageObject.childmenu_Dropdown("Cheque- Inputter Menu", 1);
        PageObject.childmenu_Dropdown("Cheque Issuance", 1);
        PageObject.childmenu_Dropdown("Cheq  Bulk Issuance Menu A\\c Holder", 1);
        PageObject.menu_Link("Issuance Banker Chq- A/c Holder Bulk- Step-2 ");

        PageObject.parentFrame();
        PageObject.switchFrame(2);
        String pgnameo = driver.getWindowHandle();

        String menu1 = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();

        PageObject.textinput_Locator("value:2:1:1","");
        PageObject.find_Button();
        Thread.sleep(2000);

    }

    @Test(groups = {"Inputter"})
    public void CollectBankerChqWCustSingleBulkStep1 () throws IOException, InterruptedException {

        PageObject.menu_Dropdown("Remittance Menu -Universal Teller- IBG");
        PageObject.childmenu_Dropdown("Cheque- Inputter Menu", 1);
        PageObject.childmenu_Dropdown("Cheque Issuance", 1);
        PageObject.childmenu_Dropdown("Cheq Bulk Issuance Menu Walkin Cust", 1);
        PageObject.childmenu_Link("Collect Banker Chq W/Cust-Single/Bulk- Step-1 ", 1);

        PageObject.parentFrame();
        PageObject.switchFrame(2);
        String pgnameo = driver.getWindowHandle();

        PageObject.img_Button("New Deal");
        PageObject.textinput_Locator("fieldName:AMOUNT.LOCAL.1:1", "10");
        PageObject.switchToChildWindow();
        PageObject.switchFrame(2);
        PageObject.textinput_Locator("fieldName:NO.OF.INST", "2");
        PageObject.switchToChildWindow();
        PageObject.switchFrame(2);
        PageObject.select_Locator("fieldName:INS.ISS.PURPOSE","Clearing/Forwarding Charges");
        PageObject.switchToParentWindow(pgnameo);
        PageObject.switchToChildWindow();
        PageObject.switchFrame(2);
        PageObject.commitDeal("CollectBankerChqWCustSingleBulkStep1");
        PageObject.switchToChildWindow();

    }

    @Test(groups = {"Inputter"})
    public void IssuanceBankerChqWalkingCustBulkStep2 () throws IOException {

        PageObject.menu_Dropdown("Remittance Menu -Universal Teller- IBG");
        PageObject.childmenu_Dropdown("Cheque- Inputter Menu", 1);
        PageObject.childmenu_Dropdown("Cheque Issuance", 1);
        PageObject.childmenu_Dropdown("Cheq Bulk Issuance Menu Walkin Cust", 1);
        PageObject.menu_Link("Issuance Banker Chq Walking Cust Bulk- Step-2 ");

        PageObject.parentFrame();
        PageObject.switchFrame(2);
        String pgnameo = driver.getWindowHandle();

    }

    @Test(groups = {"Inputter"})
    public void CollectBankerChqAmtVendorBulkStep1 () throws IOException, InterruptedException {

        PageObject.menu_Dropdown("Remittance Menu -Universal Teller- IBG");
        PageObject.childmenu_Dropdown("Cheque- Inputter Menu", 1);
        PageObject.childmenu_Dropdown("Cheque Issuance", 1);
        PageObject.childmenu_Dropdown("Cheq Bulk Issuance Menu Vendor Paymt", 1);
        PageObject.childmenu_Link("Collect Banker Chq Amt - Vendor Bulk- Step-1 ", 1);

        PageObject.parentFrame();
        PageObject.switchFrame(2);
        String pgnameo = driver.getWindowHandle();

        PageObject.img_Button("New Deal");
        PageObject.textinput_Locator("fieldName:NO.OF.INST","2");
        PageObject.textinput_Locator("fieldName:BEN.CUSTOMER:1", "Waqas");
        PageObject.textinput_Locator("fieldName:CREDIT.AMOUNT", "14");
        PageObject.textinput_Locator("fieldName:ORDERING.BANK:1", "BAL");
        PageObject.commitDeal("CollectBankerChqAmtVendorBulkStep1");
        PageObject.switchToChildWindow();

    }

    @Test(groups = {"Inputter"})
    public void IssuanceofBankerChqVendorBulkStep2 () throws IOException {

        PageObject.menu_Dropdown("Remittance Menu -Universal Teller- IBG");
        PageObject.childmenu_Dropdown("Cheque- Inputter Menu", 1);
        PageObject.childmenu_Dropdown("Cheque Issuance", 1);
        PageObject.childmenu_Dropdown("Cheq Bulk Issuance Menu Vendor Paymt", 1);
        PageObject.menu_Link("Issuance of Banker Chq - Vendor Bulk- Step-2 ");

        PageObject.parentFrame();
        PageObject.switchFrame(2);
        String pgnameo = driver.getWindowHandle();

    }

}