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

        PageObject.parentFrame();
        PageObject.switchFrame(1);

//        PageObject.img_Button("New Deal");
//
//        PageObject.textinput_Locator("fieldName:SECTOR","1000");
//        PageObject.textinput_Locator("fieldName:ID.TYPE:1","ID-N");
//        PageObject.textinput_Locator("fieldName:ID.NUMBER:1","4220179441023");
//        PageObject.click_Locator("fieldName:ID.VAL.DT:1");
    }
}
