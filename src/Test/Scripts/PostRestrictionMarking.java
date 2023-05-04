package Test.Scripts;

import POM.PageObject;
import Test.General.BaseClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class PostRestrictionMarking extends BaseClass {

    String txn;
    @Test(groups = {"Inputter"})
    public void PostRestrictionMarking() throws IOException {

        PageObject.menu_Dropdown("Customer Relation Officer Menu");
        PageObject.menu_Dropdown("Account");
        PageObject.menu_Dropdown("Account Maintenance");

        PageObject.menu_Link("Posting Restrict Marking ");

        String menu = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();

        PageObject.parentFrame();
        PageObject.switchFrame(0);

        PageObject.textinput_Locator("value:1:1:1","12105488");
        PageObject.find_Button("Run Selection");

        PageObject.parentFrame();
        PageObject.switchFrame(0);

        PageObject.form_Link("Set/Remove Posting Restrict");

        PageObject.parentFrame();
        PageObject.switchFrame(1);

        PageObject.textinput_Locator("fieldName:POSTING.RESTRICT:1","42");
        PageObject.textinput_Locator("fieldName:POST.RESTR:1","42");
        PageObject.textinput_Locator("fieldName:POSTING.DATE:1","20221223");
        PageObject.select_Locator("fieldName:POSTING.REASON:1","Blocked by CD - SS Unit");

        PageObject.commitDeal("Posting Restrict Marking ");
        txn = PageObject.getTxn();
        System.out.println(txn);
    }
}
