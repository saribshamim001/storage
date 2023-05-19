package Test.Scripts.IBG;

import POM.PageObject;
import Test.General.BaseClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class LockerForceSurrender_IBG extends BaseClass {

    String forceTxn;
    @Test(groups = {"IBGInputter"})
// Need to remove Posting restriction from the top most Locker
    public void forceSurrender_IBG() throws IOException, InterruptedException {

        PageObject.menu_Dropdown("Remittance Menu -Universal Teller- IBG");
//        PageObject.menu_Dropdown("Remittance Menu");
//        PageObject.menu_Dropdown("Alfalah Core/Retail Menu ");
        PageObject.menu_Dropdown("Locker Inputter Meu");
        PageObject.menu_Dropdown("Locker Surrender");


        PageObject.menu_Link("Locker Forced Surrender ");

        String menu = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();

        PageObject.find_Button();

        PageObject.form_Link("Locker Surrender");

        PageObject.textinput_Locator("fieldName:BRK.REASON:1", "Test");

        PageObject.commitDeal("ForceSurrender IBG");

        String menu1 = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();

        PageObject.img_Button("Commit the deal");

        forceTxn = PageObject.getTxn();
        System.out.println(forceTxn);

    }

}
