package Test.Scripts;

import POM.PageObject;
import Test.General.BaseClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class LockerVisit extends BaseClass {

    String VisitTxn;
    @Test(groups = {"Inputter"})

    public void lockerVisit() throws IOException, InterruptedException {

        PageObject.menu_Dropdown("Remittance/Clearing Officer -Universal Teller");
        PageObject.menu_Dropdown("Remittance Menu");
        PageObject.menu_Dropdown("Alfalah Core/Retail Menu ");
        PageObject.menu_Dropdown("Locker Inputter Menu");
        PageObject.menu_Dropdown("Locker Visit Register");

        PageObject.menu_Link("Locker Visit ");

        String menu = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();

        PageObject.textinput_Locator("value:1:1:1","OR.0008.0031");
        PageObject.find_Button();

        String menu2 = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();

        PageObject.img_Button("Select Drilldown");

        PageObject.textinput_Locator("fieldName:OPERATED.BY","Test");

        PageObject.commitDeal("Locker Visit ");

        VisitTxn = PageObject.getTxn();
        System.out.println(VisitTxn);


    }

}
