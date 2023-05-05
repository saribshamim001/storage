package Test.Scripts;

import POM.PageObject;
import Test.General.BaseClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class PostingRestrictRemoval_LegacyData extends BaseClass {

    String txn;

    @Test(groups = {"Inputter"})

    public void PostingRestrictRemoval_LegacyData() throws IOException, InterruptedException {

        PageObject.menu_Dropdown("Customer Relation Officer Menu");
        PageObject.menu_Dropdown("Account");
        PageObject.menu_Dropdown("Account Maintenance");

        PageObject.menu_Link("Posting Restrict Removal- Legacy Data ");

        String menu = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();

        PageObject.parentFrame();
        PageObject.switchFrame(2);

        PageObject.textinput_Locator("transactionId","1007891257");
        PageObject.img_Button("Edit a contract");

        PageObject.textinput_Locator("fieldName:POSTING.RESTRICT:1","42");
        PageObject.textinput_Locator("fieldName:REASON","Test");

        PageObject.commitDeal("PostingRestrictRemoval_LegacyData");

        txn = PageObject.getTxn();
        System.out.println(txn);

    }

}
