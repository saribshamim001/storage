package Test.Scripts.IBG;

import POM.PageObject;
import Test.General.BaseClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class BankersChequeReport_IBG extends BaseClass {

    @Test(groups = {"Inputter"})
    public void BankersChequeReport() throws InterruptedException, IOException {

        PageObject.menu_Dropdown("Remittance Menu -Universal Teller- IBG");
        PageObject.childmenu_Dropdown("Cheque- Inputter Menu", 1);
        PageObject.childmenu_Dropdown("Cheque Report",1);
        PageObject.childmenu_Link("Cheque Instrument  ", 1);

        PageObject.parentFrame();
        PageObject.switchFrame(2);
        String pgnameo = driver.getWindowHandle();

        String menu1 = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();

        PageObject.textinput_Locator("value:1:1:1","20230104");
        PageObject.find_Button();

    }

    @Test(groups = {"Authorizer"})
    public void ListOfBankersChequeInstrument () throws InterruptedException, IOException {

        PageObject.childmenu_Dropdown("Cheque- Authorizer Menu", 1);
        PageObject.childmenu_Dropdown("Cheque Report  ", 1);
        PageObject.childmenu_Link("Cheque Instrument  ", 1);

        PageObject.parentFrame();
        PageObject.switchFrame(2);
        String pgnameo = driver.getWindowHandle();

        String menu1 = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();


        PageObject.img_Button("Selection Screen");
        //PageObject.textinput_Locator("value:1:1:1","CHG2300300040");
        PageObject.find_Button();

    }

}
