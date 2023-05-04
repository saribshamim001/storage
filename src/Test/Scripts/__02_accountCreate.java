package Test.Scripts;

import POM.PageObject;
import Test.General.BaseClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class __02_accountCreate extends BaseClass {
    __01_customerCreate customer = new __01_customerCreate();

    @Test (groups = {"Inputter"})
    public void lcyCurrentAccount() throws InterruptedException {
        System.out.println(customer.Txn);

        PageObject.menu_Dropdown("Customer Relation Officer Menu");
        PageObject.menu_Dropdown("Alfalah Customer Information");
        PageObject.menu_Dropdown("Branch Level Inputter");
        PageObject.menu_Dropdown("Alfalah Account Information");
        PageObject.menu_Dropdown("Local Currency Account Open");
        PageObject.menu_Link("Current Account ");

        PageObject.parentFrame();
        PageObject.switchFrame(2);

        PageObject.img_Button("New Deal");


        PageObject.textinput_Locator("fieldName:CUSTOMER", "");
        PageObject.textinput_Locator("fieldName:CATEGORY", "");
        PageObject.textinput_Locator("fieldName:ACCOUNT.TITLE.1:1", "");
        PageObject.textinput_Locator("fieldName:ACCOUNT.TITLE.2:1", "");
        PageObject.textinput_Locator("fieldName:OTHER.OFFICER:1", "");
        PageObject.textinput_Locator("fieldName:REFEREE", "");
        PageObject.radiobutton_Locator("radio:tab1:BAF.PEN.ACCT", 1);
        PageObject.textinput_Locator("fieldName:JOINT.HOLDER:1", "");
        PageObject.textinput_Locator("fieldName:RELATION.CODE:1", "");
        PageObject.textinput_Locator("fieldName:JOINT.NOTES:1:1", "");
        PageObject.select_Locator("fieldName:MULTI.ACCT", "");

        // TAB2
        PageObject.form_Tab("PREMIER.DEBITCARD");
        PageObject.select_Locator("fieldName:BAF.PRM.IMD","");
        PageObject.textinput_Locator("fieldName:BAF.PRM.CRDNAME","");
        PageObject.radiobutton_Locator("radio:tab1:BAF.PEN.ACCT", 1);
        PageObject.textinput_Locator("fieldName:BAF.PRM.PEN","");
        PageObject.textinput_Locator("fieldName:BAF.PRM.DATETME","");

        // TAB3
        PageObject.form_Tab("Alfalah Assan Remittance");
        PageObject.textinput_Locator("fieldName:REMITTER.NAME:1","");
        PageObject.textinput_Locator("fieldName:REMITTER.ID.NO:1","");
        PageObject.textinput_Locator("fieldName:RELATIONSHIP.BE:1","");
        PageObject.textinput_Locator("fieldName:REMITTER.RESID:1","");
        PageObject.textinput_Locator("fieldName:REMITTER.ID.TYP:1","");

        PageObject.getTxn();
    }

    //    @Test
    public void lcySavingAccount() throws InterruptedException {

        PageObject.menu_Dropdown("Customer Relation Officer Menu");
        PageObject.menu_Dropdown("Alfalah Customer Information");
        PageObject.menu_Dropdown("Branch Level Inputter");
        PageObject.menu_Dropdown("Alfalah Account Information");
        PageObject.menu_Dropdown("Local Currency Account Open");
        PageObject.menu_Link("Saving Account ");

        PageObject.parentFrame();
        PageObject.switchFrame(2);

        PageObject.img_Button("New Deal");

        PageObject.textinput_Locator("fieldName:CUSTOMER", "");
        PageObject.click_Locator("fieldName:CATEGORY");
        PageObject.textinput_Locator("fieldName:CATEGORY", "");
        PageObject.textinput_Locator("fieldName:ACCOUNT.TITLE.1:1", "");
        PageObject.textinput_Locator("fieldName:ACCOUNT.TITLE.2:1", "");
        PageObject.textinput_Locator("fieldName:OTHER.OFFICER:1", "");
        PageObject.textinput_Locator("fieldName:REFEREE", "");
        PageObject.radiobutton_Locator("radio:tab1:BAF.PEN.ACCT", 1);
        PageObject.textinput_Locator("fieldName:JOINT.HOLDER:1", "");
        PageObject.textinput_Locator("fieldName:RELATION.CODE:1", "");
        PageObject.textinput_Locator("fieldName:JOINT.NOTES:1:1", "");
        PageObject.select_Locator("fieldName:MULTI.ACCT", "");

        // TAB2
        PageObject.form_Tab("PREMIER.DEBITCARD");
        PageObject.select_Locator("fieldName:BAF.PRM.IMD","");
        PageObject.textinput_Locator("fieldName:BAF.PRM.CRDNAME","");
        PageObject.radiobutton_Locator("fieldName:BAF_PRM_FMEMBR", 1);
        PageObject.textinput_Locator("fieldName:BAF.PRM.PEN","");
        PageObject.textinput_Locator("fieldName:BAF.PRM.DATETME","");

        // TAB3
        PageObject.form_Tab("Alfalah Assan Remittance");
        PageObject.textinput_Locator("fieldName:REMITTER.NAME:1","");
        PageObject.textinput_Locator("fieldName:REMITTER.ID.NO:1","");
        PageObject.textinput_Locator("fieldName:RELATIONSHIP.BE:1","");
        PageObject.textinput_Locator("fieldName:REMITTER.RESID:1","");
        PageObject.textinput_Locator("fieldName:REMITTER.ID.TYP:1","");

        PageObject.getTxn();
    }

    //    @Test
    public void lcyKidsAccount() throws InterruptedException {

        PageObject.menu_Dropdown("Customer Relation Officer Menu");
        PageObject.menu_Dropdown("Alfalah Customer Information");
        PageObject.menu_Dropdown("Branch Level Inputter");
        PageObject.menu_Dropdown("Alfalah Account Information");
        PageObject.menu_Dropdown("Local Currency Account Open");
        PageObject.menu_Link("Alfalah SnaPack Kids Account ");

        PageObject.parentFrame();
        PageObject.switchFrame(2);

        PageObject.img_Button("New Deal");

        PageObject.textinput_Locator("fieldName:CUSTOMER", "");
        PageObject.click_Locator("fieldName:ACCOUNT.TITLE.1:1");
        PageObject.textinput_Locator("fieldName:ACCOUNT.TITLE.1:1", "");
        PageObject.textinput_Locator("fieldName:ACCOUNT.TITLE.2:1", "");
        PageObject.textinput_Locator("fieldName:OTHER.OFFICER:1", "");
        PageObject.textinput_Locator("fieldName:JOINT.HOLDER:1", "");
        PageObject.textinput_Locator("fieldName:RELATION.CODE:1", "");
        PageObject.textinput_Locator("fieldName:JOINT.NOTES:1:1", "");

        PageObject.getTxn();
    }

    //    @Test
    public void fcyCurrentAccount() throws InterruptedException {

        PageObject.menu_Dropdown("Customer Relation Officer Menu");
        PageObject.menu_Dropdown("Alfalah Customer Information");
        PageObject.menu_Dropdown("Branch Level Inputter");
        PageObject.menu_Dropdown("Alfalah Account Information");
        PageObject.menu_Dropdown("Foreign Currency Account Open");
        PageObject.menu_Link("Current Account ");

        PageObject.parentFrame();
        PageObject.switchFrame(2);

        PageObject.img_Button("New Deal");

        PageObject.textinput_Locator("fieldName:CUSTOMER", "");
        PageObject.textinput_Locator("fieldName:CURRENCY", "");
        PageObject.textinput_Locator("fieldName:ACCOUNT.TITLE.1:1", "");
        PageObject.textinput_Locator("fieldName:ACCOUNT.TITLE.2:1", "");
        PageObject.textinput_Locator("fieldName:OTHER.OFFICER:1", "");
        PageObject.select_Locator("fieldName:MULTI.ACCT", "");
        PageObject.textinput_Locator("fieldName:REFEREE", "");
        PageObject.textinput_Locator("fieldName:JOINT.HOLDER:1", "");
        PageObject.textinput_Locator("fieldName:RELATION.CODE:1", "");
        PageObject.textinput_Locator("fieldName:JOINT.NOTES:1:1", "");

        PageObject.getTxn();
    }

    //    @Test
    public void fcySavingAccount() throws InterruptedException {

        PageObject.menu_Dropdown("Customer Relation Officer Menu");
        PageObject.menu_Dropdown("Alfalah Customer Information");
        PageObject.menu_Dropdown("Branch Level Inputter");
        PageObject.menu_Dropdown("Alfalah Account Information");
        PageObject.menu_Dropdown("Foreign Currency Account Open");
        PageObject.menu_Link("Saving Account ");

        PageObject.parentFrame();
        PageObject.switchFrame(2);

        PageObject.img_Button("New Deal");

        PageObject.textinput_Locator("fieldName:CUSTOMER", "");
        PageObject.textinput_Locator("fieldName:CATEGORY", "");
        PageObject.textinput_Locator("fieldName:CURRENCY", "");
        PageObject.textinput_Locator("fieldName:ACCOUNT.TITLE.1:1", "");
        PageObject.textinput_Locator("fieldName:ACCOUNT.TITLE.2:1", "");
        PageObject.textinput_Locator("fieldName:OTHER.OFFICER:1", "");
        PageObject.select_Locator("fieldName:MULTI.ACCT", "");
        PageObject.textinput_Locator("fieldName:REFEREE", "");
        PageObject.textinput_Locator("fieldName:JOINT.HOLDER:1", "");
        PageObject.textinput_Locator("fieldName:RELATION.CODE:1", "");
        PageObject.textinput_Locator("fieldName:JOINT.NOTES:1:1", "");

        PageObject.getTxn();
    }

    //    @Test
    public void accountAuthorization() throws InterruptedException, IOException {

        PageObject.menu_Dropdown("Customer Services");
        PageObject.menu_Dropdown("Alfalah Customer Information");
        PageObject.menu_Dropdown("Branch Level Authorization");
        PageObject.menu_Dropdown("Authorization of CIF & ACCOUNT");
        PageObject.menu_Dropdown("Authorization of Account");
        PageObject.menu_Link("Authorization for Account- Branch Level ");


        homePage = PageObject.switchToChildWindow();

//        PageObject.textinput_Locator("value:1:1:1",PageObject.TxnNum);
        PageObject.click_Locator("defaultButton");
        PageObject.form_Link("Authorise");
        PageObject.authorizeDeal();

        PageObject.commitDeal("Accounts");
    }
}