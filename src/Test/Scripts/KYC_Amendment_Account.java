package Test.Scripts;

import POM.PageObject;
import Test.General.BaseClass;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.IOException;

public class KYC_Amendment_Account extends BaseClass {

    String txn;

    @Test(groups = {"Inputter"})

    public void KYC_Amendment_Account() throws IOException, InterruptedException {
        PageObject.menu_Dropdown("Customer Relation Officer Menu");
        PageObject.menu_Dropdown("Alfalah Customer Information");
        PageObject.menu_Dropdown("Branch Level Inputter");
        PageObject.menu_Dropdown("Alfalah KYC Information");
        PageObject.menu_Dropdown("Alfalah Account KYC Information");

        PageObject.menu_Link("KYC Amendment Account ");

        String menu = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();

        PageObject.textinput_Locator("value:1:1:1","1007240180");
        PageObject.find_Button();


        PageObject.form_Link("Amend Account KYC");

        Thread.sleep(2000);

        String menu2 = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();

        PageObject.img_Button("Commit the deal");

        driver.close();

        PageObject.switchToParentWindow(menu2);
        PageObject.maximizeWindow();



        PageObject.textinput_Locator("fieldName:PURPOSE","Test1");
        PageObject.select_Locator("fieldName:MODEDEPOSITS:1","Cheque");
        PageObject.select_Locator("fieldName:MODEDEPOSITS:2","Cash");
        PageObject.select_Locator("fieldName:MODEDEPOSITS:3","Online Credits");
        PageObject.select_Locator("fieldName:MODEWITHDRAW:1","Issuing crossed Cheques");
        PageObject.select_Locator("fieldName:MODEWITHDRAW:2","Cash Withdrawls through cheque");
//        PageObject.select_Locator("fieldName:MODEWITHDRAW:3","Outward local Remittance");
        PageObject.textinput_Locator("fieldName:KYC.NO.TRANS","8");
        PageObject.textinput_Locator("fieldName:NO.TRANS.DR","9");
        PageObject.select_Locator("fieldName:MONTH.TOVER.DR","1M to 5M");
        PageObject.textinput_Locator("fieldName:EX.TOVER.DR.OTH","100000");

        PageObject.select_Locator("fieldName:KYC.ATO","Below 1M");
        PageObject.textinput_Locator("fieldName:ATOGTM","1000");
        PageObject.select_Locator("fieldName:MONTH.TOVER.RG","1M to 5M");
        PageObject.textinput_Locator("fieldName:EXP.MONTH.TOVER","10000");

        PageObject.img_Button("Commit the deal");

        String menu3 = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();

        PageObject.select_Locator("fieldName:CUST.SEGMENT","AFFLUENT");
        PageObject.img_Button("Commit the deal");

        driver.close();

        PageObject.switchToParentWindow(menu3);
        PageObject.maximizeWindow();

        PageObject.select_Locator("fieldName:OCCUPATION","Salaried");
        PageObject.commitDeal("KYC Amendment Account");



////        PageObject.radiobutton_Locator("radio:mainTab:KYC.CO.ATO",'0');
////        PageObject.textinput_Locator("fieldName:SFUNDOTH","Testing");
////        PageObject.radiobutton_Locator("radio:mainTab:KYC.REASON.HIGH",'0');
////        PageObject.radiobutton_Locator("radio:mainTab:MON.TOVER.CRG",'0');
//
//        PageObject.commitDeal("KYC Amendment Account ");
//
//        String menu3 = PageObject.switchToChildWindow();
//        PageObject.maximizeWindow();
//        PageObject.commitDeal("KYC Amendment Account ");
//
//
//
//
//        txn = PageObject.getTxn();
//        System.out.println(txn);

    }

}
