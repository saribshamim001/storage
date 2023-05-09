package Test.Scripts;

import POM.PageObject;
import Test.General.BaseClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class LockerSurrender extends BaseClass {

    String lockerTxn;
    @Test(groups = {"Inputter"})

    public void LockerSurrender() throws IOException, InterruptedException {

        PageObject.menu_Dropdown("Remittance/Clearing Officer -Universal Teller");
        PageObject.menu_Dropdown("Remittance Menu");
        PageObject.menu_Dropdown("Alfalah Core/Retail Menu ");
        PageObject.menu_Dropdown("Locker Inputter Menu");
        PageObject.menu_Dropdown("Locker Surrender");


        PageObject.menu_Link("Locker Surrender ");

        String menu = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();

        PageObject.find_Button();

        PageObject.form_Link("Surrender Version");

        PageObject.textinput_Locator("fieldName:BRK.REASON:1","Test");

        PageObject.commitDeal("Locker Surrender");

        String menu1 = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();

        PageObject.img_Button("Commit the deal");

        lockerTxn = PageObject.getTxn();
        System.out.println(lockerTxn);

    }

    }
