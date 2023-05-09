package Test.Scripts;

import POM.PageObject;
import Test.General.BaseClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class ForceSurrender extends BaseClass {

    String forceTxn;
    @Test(groups = {"Inputter"})

    public void forceSurrender() throws IOException, InterruptedException {

        PageObject.menu_Dropdown("Remittance/Clearing Officer -Universal Teller");
        PageObject.menu_Dropdown("Remittance Menu");
        PageObject.menu_Dropdown("Alfalah Core/Retail Menu ");
        PageObject.menu_Dropdown("Locker Inputter Menu");
        PageObject.menu_Dropdown("Locker Surrender");


        PageObject.menu_Link("Locker Forced Surrender ");

        String menu = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();

        PageObject.find_Button();

        PageObject.form_Link("Locker Surrender");

        PageObject.textinput_Locator("fieldName:BRK.REASON:1", "Test");

        PageObject.commitDeal("ForceSurrender");

        String menu1 = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();

        PageObject.img_Button("Commit the deal");

        forceTxn = PageObject.getTxn();
        System.out.println(forceTxn);

    }



    }
