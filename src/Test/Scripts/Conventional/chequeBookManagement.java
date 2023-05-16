package Test.Scripts.Conventional;

import POM.PageObject;
import Test.General.BaseClass;
import org.testng.annotations.Test;
import java.io.IOException;

public class chequeBookManagement extends BaseClass {

    public static String Txn="";
    public static String chq="CD.1007306919.0000004";

    @Test(groups = {"Inputter"})
    public void Issuance() throws InterruptedException, IOException {
        PageObject.menu_Dropdown("Customer Relation Officer Menu");
        PageObject.menu_Dropdown("Cheque Book Management Inputter Menu");
        PageObject.menu_Link("Cheque Book Request For Issuance to CBU ");

        PageObject.parentFrame();
        PageObject.switchFrame(2);

        PageObject.textinput_Locator("transactionId",chq); //CD.1007306919.0000004
        PageObject.img_Button("Edit a contract");

        String Deal = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();
        driver.close();

        PageObject.switchToParentWindow(Deal);
        PageObject.switchFrame(2);

        PageObject.textinput_Locator("fieldName:ORDERING.DATE","20221124");
        PageObject.select_Locator("fieldName:ISSUED.AGAINST","REQUISTION EXISTING A/C");
        PageObject.select_Locator("fieldName:NO.CHQ.ISSUED","25");
        PageObject.textinput_Locator("fieldName:LAST.SERIAL","34314526");
        PageObject.textarea_Locator("fieldName:NOTES","CHEQUEBOOK ISSUED");
        PageObject.radiobutton_Locator("radio:tab1:WAIVE.CHARGES",1);

        PageObject.commitDeal("chequeBookIssued");

    }


    @Test(groups = {"Inputter"})
    public void Received() throws InterruptedException, IOException {
        PageObject.menu_Dropdown("Customer Relation Officer Menu");
        PageObject.menu_Dropdown("Cheque Book Management Inputter Menu");
        PageObject.menu_Link("Cheque Book Received From CPU ");

        homePage = PageObject.switchToChildWindow();
        PageObject.switchFrame(0);

        PageObject.textinput_Locator("value:1:1:1",chq); //CD.1008203610.0000001
        PageObject.click_Locator("defaultButton");
        PageObject.form_Link("Received Cheque Book");

        PageObject.parentFrame();
        PageObject.switchFrame(1);

        PageObject.textinput_Locator("fieldName:CHQ.NO.STARTS","34563486");
        PageObject.textarea_Locator("fieldName:NOTES","CHEQUEBOOK RECEIVED");
        PageObject.radiobutton_Locator("radio:tab1:WAIVE.CHARGES",1);

        PageObject.commitDeal("chequeBookReceived");
        Txn = PageObject.getTxn();

    }


    @Test(groups = {"Authorizer"})
    public void Received_Authorization() throws InterruptedException, IOException {


        PageObject.menu_Dropdown("Customer Services");
        PageObject.menu_Dropdown("Cheque Book Management Authorizer Menu");
        PageObject.menu_Link("Authorization Received From CPU ");

        homePage = PageObject.switchToChildWindow();
        PageObject.switchFrame(0);

        PageObject.textinput_Locator("value:1:1:1",Txn);
        PageObject.click_Locator("defaultButton");
        PageObject.form_Link("Authorize");
        PageObject.authorizeDeal();

    }


    @Test(groups = {"Inputter"})
    public void DeliveredTo3rdParty() throws InterruptedException, IOException {
        PageObject.menu_Dropdown("Customer Relation Officer Menu");
        PageObject.menu_Dropdown("Cheque Book Management Inputter Menu");
        PageObject.menu_Link("Cheque Book Delivered to Third Party ");

        homePage = PageObject.switchToChildWindow();

        PageObject.textinput_Locator("value:1:1:1",chq); //CD.1008203610.0000001
        PageObject.click_Locator("defaultButton");
        PageObject.form_Link("Delivered to third Party");

        PageObject.textinput_Locator("fieldName:DELIV.TO.CUS","AFFAN");
        PageObject.textinput_Locator("fieldName:CNIC.CUS","4098674826453");
        PageObject.textarea_Locator("fieldName:NOTES","CHEQUEBOOK DELIVERED");

        PageObject.commitDeal("chequeBookDelivered");
        Txn = PageObject.getTxn();


    }

    @Test(groups = {"Authorizer"})
    public void DeliveredTo3rdParty_Authorization() throws InterruptedException, IOException {


        PageObject.menu_Dropdown("Customer Services");
        PageObject.menu_Dropdown("Cheque Book Management Authorizer Menu");
        PageObject.menu_Link("Authorization of Third Party Delivery ");

        homePage = PageObject.switchToChildWindow();
        PageObject.switchFrame(0);

        PageObject.textinput_Locator("value:1:1:1",Txn);
        PageObject.click_Locator("defaultButton");
        PageObject.form_Link("Authorize");

        Thread.sleep(5000);

        //frame not found issue!
        PageObject.parentFrame();
        PageObject.switchFrame(1);
        PageObject.authorizeDeal();

    }


    @Test(groups = {"Inputter"})
    public void Activation() throws InterruptedException, IOException {
        PageObject.menu_Dropdown("Customer Relation Officer Menu");
        PageObject.menu_Dropdown("Cheque Book Management Inputter Menu");
        PageObject.menu_Link("Cheque Book Activation ");

        homePage = PageObject.switchToChildWindow();
        PageObject.switchFrame(0);

        PageObject.textinput_Locator("value:1:1:1",chq); //CD.1008203610.0000001
        PageObject.click_Locator("defaultButton");
        PageObject.form_Link("Activate Cheque Book");

        PageObject.parentFrame();
        PageObject.switchFrame(1);

        PageObject.select_Locator("fieldName:ISSUED.AGAINST","REQUISTION EXISTING A/C");
        PageObject.textinput_Locator("fieldName:CHQ.NO.START","34563486"); //34314526
        PageObject.textarea_Locator("fieldName:NOTES","CHEQUEBOOK ISSUED");

        PageObject.commitDeal("chequeBookActivated");
        Txn = PageObject.getTxn();

    }

    @Test(groups = {"Authorizer"})
    public void ActivationAuth() throws InterruptedException, IOException {


        PageObject.menu_Dropdown("Customer Services");
        PageObject.menu_Dropdown("Cheque Book Management Authorizer Menu");
        PageObject.menu_Link("Authorization of Cheque Book Activation ");

        homePage = PageObject.switchToChildWindow();
        PageObject.switchFrame(0);

        PageObject.textinput_Locator("value:1:1:1",Txn);
        PageObject.click_Locator("defaultButton");
        PageObject.form_Link("Authorize");

        Thread.sleep(5000);

//        PageObject.parentFrame();
//        PageObject.switchFrame(1);
        PageObject.authorizeDeal();

    }







//        @Test(groups = {"Inputter"})
    public void overrideTC() throws InterruptedException, IOException {
        PageObject.menu_Dropdown("Customer Relation Officer Menu");
        PageObject.menu_Dropdown("Cheque Book Management Inputter Menu");
        PageObject.menu_Link("Cheque Book Request For Issuance to CBU ");

        PageObject.parentFrame();
        PageObject.switchFrame(2);

        PageObject.textinput_Locator("transactionId",chq); //CD.1007306919.0000004
        PageObject.img_Button("Edit a contract");

        String Deal = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();
        driver.close();

        PageObject.switchToParentWindow(Deal);
        PageObject.switchFrame(2);

        PageObject.textinput_Locator("fieldName:ORDERING.DATE","20221124");
        PageObject.select_Locator("fieldName:ISSUED.AGAINST","FORM B");
        PageObject.select_Locator("fieldName:NO.CHQ.ISSUED","25");
        PageObject.textinput_Locator("fieldName:LAST.SERIAL","34314526");
        PageObject.textarea_Locator("fieldName:NOTES","CHEQUEBOOK ISSUED");
        PageObject.radiobutton_Locator("radio:tab1:WAIVE.CHARGES",1);

        PageObject.commitDeal("chequeBookIssued");
    }




}
