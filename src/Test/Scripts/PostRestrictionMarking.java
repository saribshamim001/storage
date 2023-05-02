package Test.Scripts;

import POM.PageObject;
import Test.General.BaseClass;
import org.testng.annotations.Test;

public class PostRestrictionMarking extends BaseClass {

    @Test(groups = {"Inputter"})
    public void PostRestrictionMarking() {

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

        PageObject.menu_Link("Set/Remove Posting Restrict");
    }
}
