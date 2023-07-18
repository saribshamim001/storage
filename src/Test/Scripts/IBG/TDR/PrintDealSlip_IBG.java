package Test.Scripts.IBG.TDR;

import POM.PageObject;
import Test.General.BaseClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class PrintDealSlip_IBG extends BaseClass {

    @Test(groups = {"InputterTDR_IBG"})
    public void PrintTDRReciept  () throws IOException, InterruptedException {

        PageObject.menu_Dropdown("Centralized TDR Menu - IBG");
        PageObject.childmenu_Dropdown("Print IBG Deal Slip", 1);
        PageObject.childmenu_Link("Print TDR Reciept ", 1);

        String menu = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();
        PageObject.switchFrame(0);

        PageObject.textinput_Locator("value:1:1:1", "LD1419712927");
        PageObject.find_Button();
        PageObject.form_Link("View Deal Slip");

    }

    @Test(groups = {"InputterTDR_IBG"})
    public void PrintTDRRecieptRollover   () throws IOException, InterruptedException {

        PageObject.menu_Dropdown("Centralized TDR Menu - IBG");
        PageObject.childmenu_Dropdown("Print IBG Deal Slip", 1);
        PageObject.childmenu_Link("Print TDR Reciept Rollover ", 1);

        String menu = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();
        PageObject.switchFrame(0);

        PageObject.textinput_Locator("value:1:1:1", "LD1419712927");
        PageObject.find_Button();
        PageObject.form_Link("View Deal Slip");

    }
}
