/*
package Test.Scripts;

import POM.PageObject;
import Test.General.BaseClass;
import org.testng.annotations.Test;

import java.io.IOException;

//import static Test.General.ExtraMethods.*;

public class cashDepostLCY extends BaseClass {

    @Test(groups = "Inputter")
    public void CashDepoOnlineLcy_Override() throws InterruptedException, IOException {
        PageObject.menu_Dropdown("Head Teller Menu-Universal Teller-Conventiona");
        PageObject.menu_Dropdown("Teller");
        PageObject.menu_Dropdown("Teller Menu");
        PageObject.menu_Dropdown("Teller Cash");
        PageObject.menu_Link("LCY cash deposit - LCY A/c Online ");

        PageObject.parentFrame();
        PageObject.switchFrame(2);

        PageObject.img_Button("New Deal");

        PageObject.textinput_Locator("fieldName:ACCOUNT.1:1", "1000321229");
        refreshWindow(2);
//        changeFrame(2);

        PageObject.textinput_Locator("fieldName:AMOUNT.LOCAL.1:1", "1000");
//        changeFrame(2);
        refreshWindow(2);

        PageObject.textinput_Locator("fieldName:CASH.DSLIPNO", "1000001");
        PageObject.radiobutton_Locator("radio:tab1:AML.TYP.CUST", 2);
        PageObject.textinput_Locator("fieldName:CX.ACCOUNT", "1000321229");
        refreshWindow(2);
//        PageObject.switchFrame(2);
        PageObject.textarea_Locator("fieldName:NAME.COND.TXN", "ABDULLMANAF");
        PageObject.textinput_Locator("fieldName:TT.ID.TYPE:1", "ID-N");
        PageObject.textinput_Locator("fieldName:TT.ID.VAL.DT:1", "20250101");
        PageObject.textinput_Locator("fieldName:CNIC.NO", "9876543215875");

        */
/*String newPage = PageObject.switchToChildWindow();
        PageObject.switchFrame(2);*//*


        refreshWindow(2);

        PageObject.textarea_Locator("fieldName:OTHER.REMARKS", "Testingtestingtestingtestingtestingtestingtestingtestingtestingtestingtestingtestingtestingtestingtestingtestingtestingtestingtestingtestingtestingtestingtestingtestingtestingtestingtestingtestingtestingtestingtestingtestingtestingtestingtestingtestingtestingtestingtestingtestingtestingtestingtestingtestingtestingtestingtestingtestingtesting ");
        PageObject.textinput_Locator("fieldName:DATE.OF.BIRTH", "19800101");
        PageObject.textinput_Locator("fieldName:FATHER.NAME", "someone");
        commitDeal("cashDepostLCY");
        */
/*driver.close();
        PageObject.switchToParentWindow(homePage);
        PageObject.parentFrame();
        PageObject.switchFrame(0);
        PageObject.signOff();*//*


    }
}
*/
