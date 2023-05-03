package Test.Scripts;

import POM.PageObject;
import Test.General.BaseClass;
import org.testng.annotations.Test;
import java.io.IOException;

public class __03_chequeBookManagement extends BaseClass {
    @Test
    public void chequeBookIssuance() throws InterruptedException, IOException {
        PageObject.menu_Dropdown("Customer Relation Officer Menu");
        PageObject.menu_Dropdown("Cheque Book Management Inputter Menu");
        PageObject.menu_Link("Cheque Book Request For Issuance to CBU ");

        PageObject.parentFrame();
        PageObject.switchFrame(2);

        PageObject.textinput_Locator("transactionId","CD.1007306919.0000004"); //CD.1007306919.0000003

//       check ??
        PageObject.img_Button("Edit a contract");
//        PageObject.close();
        PageObject.textinput_Locator("fieldName:ORDERING.DATE","24 NOV 2022");
        PageObject.select_Locator("fieldName:ORDERING.DATE","REQUISTION EXISTING A/C");
        PageObject.select_Locator("fieldName:NO.CHQ.ISSUED","25");
        PageObject.textinput_Locator("fieldName:LAST.SERIAL","34314526");
        PageObject.radiobutton_Locator("radio:tab1:WAIVE.CHARGES",1);

        PageObject.commitDeal("chequeBookIssued");
    }

    }
