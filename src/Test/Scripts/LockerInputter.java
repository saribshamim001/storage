package Test.Scripts;

import POM.PageObject;
import Test.General.BaseClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class LockerInputter extends BaseClass {

    String lockerTxn;
    String amendSingleTxn;
    String amendJointTxn;

    @Test(groups = {"Inputter"})

    public void assignLocker() throws IOException, InterruptedException {

        PageObject.menu_Dropdown("Remittance/Clearing Officer -Universal Teller");
        PageObject.menu_Dropdown("Remittance Menu");
        PageObject.menu_Dropdown("Alfalah Core/Retail Menu ");
        PageObject.menu_Dropdown("Locker Inputter Menu");
        PageObject.menu_Dropdown("Assign Locker");


        PageObject.menu_Link("Assign Locker ");

        String menu = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();

        PageObject.form_Link("Joint");

        PageObject.textinput_Locator("fieldName:KEY","1");
        PageObject.textinput_Locator("fieldName:CUSTOMER","12105488");
        PageObject.click_Locator("fieldName:CUST.ACCT");

        Thread.sleep(2000);

        PageObject.textinput_Locator("fieldName:CUST.ACCT","1004057212");
        PageObject.textinput_Locator("fieldName:JOINT.CNO:1","11745297");
        PageObject.select_Locator("fieldName:OPEARTING.INST","Jointly");
        PageObject.textinput_Locator("fieldName:OPEARTING.NAME:1","Test J");
        PageObject.radiobutton_Locator("radio:mainTab:CHARGES.WAIVE",2);
        PageObject.radiobutton_Locator("radio:mainTab:KEY.DEPOSIT",1);
        PageObject.radiobutton_Locator("radio:tab1:MANDATEE",2);


        PageObject.commitDeal("Assign Locker");

        String menu1 = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();

        PageObject.img_Button("Commit the deal");

        lockerTxn = PageObject.getTxn();
        System.out.println(lockerTxn);
    }

    @Test(groups = {"Inputter"})

    public void amendmentLockerSingle() throws IOException, InterruptedException {

        PageObject.menu_Dropdown("Remittance/Clearing Officer -Universal Teller");
        PageObject.menu_Dropdown("Remittance Menu");
        PageObject.menu_Dropdown("Alfalah Core/Retail Menu ");
        PageObject.menu_Dropdown("Locker Inputter Menu");
        PageObject.menu_Dropdown("Locker Amendment");


        PageObject.menu_Link("Amendment of Locker Single ");

        String menu = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();

        PageObject.textinput_Locator("value:1:1:1","OR.0002.0031");
        PageObject.find_Button();


        PageObject.form_Link("Amendment Version");

        PageObject.textinput_Locator("fieldName:KEY","2");
        PageObject.select_Locator("fieldName:STATUS","ASSIGNED");
        PageObject.textinput_Locator("fieldName:CUST.ACCT","1003160019");
        PageObject.radiobutton_Locator("radio:tab1:CHARGES.WAIVE",1);
        PageObject.textinput_Locator("fieldName:BRK.REASON:1","Testing");

        PageObject.commitDeal("Amendment of Locker Single ");

        amendSingleTxn = PageObject.getTxn();
        System.out.println(amendSingleTxn);
    }

    @Test(groups = {"Inputter"})

    public void amendmentLockerJoint() throws IOException, InterruptedException {

        PageObject.menu_Dropdown("Remittance/Clearing Officer -Universal Teller");
        PageObject.menu_Dropdown("Remittance Menu");
        PageObject.menu_Dropdown("Alfalah Core/Retail Menu ");
        PageObject.menu_Dropdown("Locker Inputter Menu");
        PageObject.menu_Dropdown("Locker Amendment");


        PageObject.menu_Link("Amendment of Locker Joint ");

        String menu = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();

        PageObject.textinput_Locator("value:1:1:1","OR.0003.0031");
        PageObject.find_Button();


        PageObject.form_Link("Joint Amendment Version");


        PageObject.textinput_Locator("fieldName:KEY","3");
        PageObject.select_Locator("fieldName:STATUS","ASSIGNED");
        PageObject.textinput_Locator("fieldName:CUST.ACCT","1007515120");
        PageObject.radiobutton_Locator("radio:tab1:CHARGES.WAIVE",1);
        PageObject.textinput_Locator("fieldName:BRK.REASON:1","Testing");

        PageObject.commitDeal("AmendmentLockerJoint");

        amendJointTxn = PageObject.getTxn();
        System.out.println(amendJointTxn);
    }


}
